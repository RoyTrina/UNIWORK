#-------------------------------------------------------------------------------
# s x c v . p y   --   user-friendly OpenCV wrappers for CE316/866
#-------------------------------------------------------------------------------

"""OpenCV is written in C++ and is really intended for speed of
execution.  Its Python wrappers are provided by the cv2 module and are
quite "thin", meaning that the calls mimic closely the C++ ones.  That
means they are less elegant than they could be for a Python
programmer.  Fortunately, the image representation used by OpenCV is
that of a numpy array, so we are able to build on both its and OpenCV's
functionality.

This module wraps some OpenCV and numpy functions to make it more
convenient for a programmer -- or Computer Vision student -- to use.
The functionality it provides as supplied is quite limited because the
intention is that YOU add further routines to it to provide specific
new capabilities.  For each new capability to be added, you will be
given the specification of the routine and some tests, supplied as
text in its introductory comment, and you add the code to do the
processing.  The first laboratory script gives an example and the next
few use the same approach.  You test that you have your functionality
right by typing the shell command:

   python -m doctest sxcv.py

This pulls out all of the tests from the comments in the file and
determines whether or not the routines produce the expected outputs.
Successes, cases where the output is as expected, are normally not
reported but failures are.  Adding the "-v" qualifier to the above
command makes the doctest module output information about each test as
it is carried out.

With the necessary functions written, you will be able to integrate them
into complete programs that do useful computer vision tasks in the
second half of the laboratory programme.

The easiest way to read through all the documentation in this file is by
typing the command:

   pydoc sxcv

For the interested reader, the documentation at the top of each
routine uses Google's style of Python docstrings because it is
arguably the easiest to type and (to the author's eye) the most
elegant-looking when printed out unprocessed.  I wish those in charge
of the Python language would specify what we should all use!

"""

#-------------------------------------------------------------------------------
# Boilerplate.
#-------------------------------------------------------------------------------

import sys, os, platform, tempfile
import cv2, numpy
import matplotlib.pylab as plt

#-------------------------------------------------------------------------------
# MODULE INITIALIZATION.
#-------------------------------------------------------------------------------

# Set the default values of global variables.
DEBUG = False

# We occasionally have to do things differently on different operating systems,
# so figure out what we're running on.
systype = platform.system ()

# Extract any settings from the environment variable "SXCV" and store them in
# the global list ENVIRONMENT.
key =  "SXCV"
if key in os.environ:
    val = os.environ[key].lower ()
    ENVIRONMENT = val.split ()
    # Set our globals according to keywords in the environment variable.
    if "debug" in ENVIRONMENT: DEBUG = True
else:
    ENVIRONMENT = []

#-------------------------------------------------------------------------------
# DEBUGGING SUPPORT.
#-------------------------------------------------------------------------------
# The library is able to provide some limited debugging information for users.
# Our "debug mode" can be turned on or off explicitly by the program, and the
# neatest way of doing that is to support a "-debug" command-line qualifier in
# programs, invoking sx.debug_on() if it was provided.  However, even for
# programs that do not do this, we can enable debugging mode by setting the
# environment variable "SXCV" to include the word "debug".  The environment
# variable can also contain other keywords; the complete set is:
#
# debug: enable the output of debugging information and image displays.
#
# sixel16: images displayed via sxsv.ddisplay will, if the system supports it,
#    appear directly in the terminal window.
#
# sixel256: images displayed via sxsv.ddisplay will, if the system supports it,
#    appear directly in the terminal window.
#
# Sixel graphics are not widely reported and not all that widely used but they
# are a really useful way of reviewing and comparing the effects of processing.
# To be able to view them, you need to do a little preparatory work:
#
#   +  On a Mac, you need to install the "img2sixel" program via Homebrew:
#         brew install libsixel
#      AND be using iTerm2 (https://iterm2.com) rather than the standard
#      Terminal application.  iTerm2 is better than Terminal anyway.
#      Set "sixel256" in the SXCV envronment variable.
#
#   +  On Linux systems that run X11 rather than Wayland, you also need to
#      install the "img2sixel" program:
#         apt install libsixel-bin
#      The venerable xterm application can display sixel graphics once it is
#      configured properly.  First, put the lines:
#         xterm*decTerminalID: vt340
#         xterm*numColorRegisters: 256
#         xterm*sixelScrolling: 1
#         xterm*sixelScrollsRight: 1
#      into the file ~/.Xresources and then invoke:
#         xrdb -merge ~/.Xresources
#      You'll need to do this every time you login.  Set "sixel256" in the
#      SXCV envronment variable.  You can then start an xterm with (say):
#         xterm -fn 10x20 &
#
#   +  On Linux systems running a Wayland compositor, such as the stock
#      Ubuntu 22.04, the "foot" terminal emulator apparently supports sixel
#      graphics; I haven't yet had an opportunity to check it out.
#
#   +  On Windows, Mintty (the Cygwin terminal program) apparently supports
#      sixel graphics; further information would be welcomed.
#
# To set the environment variable on Linux or a Mac, use something like
#    export SXCV="debug sixel256"
# in your "~/.bashrc" file (for Bash) or your "~/.zshrc" file (for Z-shell).
# On Windows, you would type
#    set SXCV="debug"
# to the command prompt.

def debug_set (value):
    """
    Set the value of our debugging state.

    Args:
        value (bool): value to which the state should be set
    """
    global DEBUG

    DEBUG = value

#-------------------------------------------------------------------------------
def debugging ():
    """
    Return the debugging state.

    Args:
        none

    Returns:
        bool: whether debugging is enabled
    """
    global DEBUG

    return DEBUG

#-------------------------------------------------------------------------------
def debug_off ():
    """
    Turn off debugging.

    Args:
        none
    """
    debug_set (False)

#-------------------------------------------------------------------------------
def debug_on ():
    """
    Turn on debugging.

    Args:
        none
    """
    debug_set (True)

#-------------------------------------------------------------------------------
def ddisplay (im, title, delay=0, destroy=True):
    """Display an image when debugging.

    If the environment variable "SXCV" exists and contains the word
    "sixel16" or "sixel256", then the image is displayed in the terminal
    window via `img2sixel`; otherwise it is displayed in a conventional
    pop-up display window.  Display in the terminal window makes it easier
    to review the effects of processing.

    Args:
        im (image): image to be displayed
        title (str): information about what is being displayed
        delay (int): number of ms to display it for, or zero to wait for
                     a keypress (default: 0)
        destroy (bool): whether or not the window should be destroyed
                        after displaying
    """
    global DEBUG, ENVIRONMENT

    if debugging ():
        # For information on the following tests, see the top of this file.
        if "sixel16" in ENVIRONMENT and systype != "Windows":
            display_sixel (im, title, 16)
        elif "sixel256" in ENVIRONMENT and systype != "Windows":
            display_sixel (im, title, 256)
        else:
            display (im, title, delay, destroy)

#-------------------------------------------------------------------------------
def display_sixel (im, title, levels=256):
    """
    Display `im` as sixels via the external program `img2sixel`.

    Args:
        im (image): image to be displayed
        title (str): information about what is being displayed
        levels (int): number of output levels to be produced
                      (default: 256)
    """
    # ASIDE: As well as being useful in its own right, this routine serves as
    # a template for any other routines that need to run an external program
    # on an image.  The basic strategy is to save the image out as a temporary
    # ".png" file (it needs to be an uncompressed format), then run a shell
    # command on it.  In this particular case, the command does not create any
    # output but it is easy to edit the temporary filename to have a different
    # extension, if the external program produces an output image, and then
    # read in the result of processing via cv2.imread as usual.

    # As the sixel output goes into the terminal window, output the title
    # above it so we can find it when we scroll up the window.
    print (title + ":")

    # Save the image to a temporary file, run img2sixel on it, then delete the
    # file.
    fn = tempfile.NamedTemporaryFile (suffix=".png").name
    cv2.imwrite (fn, im)
    # The following works with at least zsh.
    cmd = "img2sixel -p %d %s 2>/dev/null" % (levels, fn)
    os.system (cmd)
    os.remove (fn)

    # Terminate the line in the output in case img2sixel didn't.
    print ()

#-------------------------------------------------------------------------------
# SUPPORT ROUTINES.
#-------------------------------------------------------------------------------

def arrowhead ():
    """Return the arrowhead image discussed in the software chapter
    of the lecture notes.

    Args:
        none

    Returns:
        im (image): numpy structure containing the image

    Tests:
        >>> im = arrowhead ()
        >>> im.shape
        (10, 9)
        >>> im[0,2]
        0
        >>> im[6,3]
        0
        >>> im[3,6]
        255

    """
    im = numpy.array ([
        [0,   0,   0,   0,   0,   0,   0,   0,   0],
        [0,   0,   0,   0, 255,   0,   0,   0,   0],
        [0,   0,   0, 255, 255, 255,   0,   0,   0],
        [0,   0, 255, 255, 255, 255, 255,   0,   0],
        [0,   0,   0,   0, 255,   0,   0,   0,   0],
        [0,   0,   0,   0, 255,   0,   0,   0,   0],
        [0,   0,   0,   0, 255,   0,   0,   0,   0],
        [0,   0,   0,   0, 255,   0,   0,   0,   0],
        [0,   0,   0,   0, 255,   0,   0,   0,   0],
        [0,   0,   0,   0,   0,   0,   0,   0,   0]
    ], dtype="uint8")
    return im

#-------------------------------------------------------------------------------
def create_mask (name):
    """
    Return one of the commonly-used convolution masks."

    Args:
        name (str): name of the mask to be generated, one of:
                    blur3, blur5, laplacian

    Returns:
        im (image): numpy array containing the mask values

    Raises:
         ValueError: when invoked with an unsupported name

    Tests:
        >>> mask = create_mask ("blur3")
        >>> print (mask)
        [[1 1 1]
         [1 1 1]
         [1 1 1]]

        >>> mask = create_mask ("blur5")
        >>> print (mask)
        [[1 1 1 1 1]
         [1 1 1 1 1]
         [1 1 1 1 1]
         [1 1 1 1 1]
         [1 1 1 1 1]]

        >>> mask = create_mask ("laplacian")
        >>> print (mask)
        [[ 1  1  1]
         [ 1 -1  1]
         [ 1  1  1]]

        >>> mask = create_mask ("whatsit")
        Traceback (most recent call last):
         ...
        ValueError: I don't know how to generate a 'whatsit' mask!
    """
    # ASIDE: One of the reasons for having this routine is to show how an
    # exception in a test is handled -- the last case above does it and the
    # exception is triggered in the trailing else case below.

    if name == "blur3":
        im = numpy.array ([
            [1, 1, 1],
            [1, 1, 1],
            [1, 1, 1]
        ], dtype="int")

    elif name == "blur5":
        im = numpy.array ([
            [1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1]
        ], dtype="int")

    elif name == "laplacian":
        im = numpy.array ([
            [1,  1, 1],
            [1, -1, 1],
            [1,  1, 1]
        ], dtype="int")

    else:
        # We have a problem.
        raise ValueError ("I don't know how to generate a '%s' mask!" % name)

    # Return the mask we have created.
    return im

#-------------------------------------------------------------------------------
def describe (im, title="Image"):
    """
    Describe the image `im`.

    Args:
        im (image): image to be described
        title (str): name associated with the image (default: "Image")

    Returns:
        str: the description to be printed

    Raises:
        ValueError: when invoked with an invalid image

    Tests:
        >>> im = arrowhead ()
        >>> print (describe (im, "This image"))
        This image is monochrome of size 10 rows x 9 columns with uint8 pixels.
    """
    text = ""
    ns = len (im.shape)
    if ns == 2:
        # A two-element shape means a monochrome image.
        ny, nx = im.shape
        channels = "is monochrome"
    elif ns == 3:
        # A three-element shape means a multi-channel image.
        ny, nx, nc = im.shape
        channels = "has %d channels" % nc
    else:
        # We have a problem.
        raise ValueError ("I have a '%d'-dimensional image!" % ns)

    # Generate the actual description.
    text += "%s %s of size %d rows x %d columns with %s pixels." % \
        (title, channels, ny, nx, im.dtype)

    # Return the text.
    return text

#-------------------------------------------------------------------------------
def display (im, title=None, delay=0, destroy=True):
    """
    Display an image via `cv2.imshow`.

    Args:
        im (image): image to be displayed
        title (str): name of the window to display it in
                     (default: program name)
        delay (int): number of ms to display it for or zero to wait for
                     a keypress (default: 0)
        destroy (bool): whether or not the window should be destroyed
                        after displaying
    """
    if title is None:
        title = sys.argv[0]
    cv2.imshow (title, im)
    cv2.waitKey (delay)
    if destroy:
        cv2.destroyWindow (title)

#-------------------------------------------------------------------------------
def examine (im, aty=None, atx=None, rows=15, cols=15, title=None):
    """
    Return the pixel values of a region of an image in a form
    suitable for printing out.

    Args:
        im (image): image to be examined
        aty (int): middle row of the region to be examined
                   (default: middle of image)
        atx (int): middle column of the region to be examined
                   (default: middle of image)
        rows (int): number of rows to be printed (default: image size)
        cols (int):  number of columns to be printed (default: image size)

    Returns:
        str: the formatted output to be printed

    Tests:
        >>> im = create_mask ("laplacian")
        >>> print (examine (im)[:-1])
        [3 x 3 region of 3 x 3-pixel monochrome image at (1,1)]:
                  0   1   2
               ------------
            0|    1   1   1
            1|    1  -1   1
            2|    1   1   1
    """
    # Work out the default values of arguments.
    ny = im.shape[0]
    nx = im.shape[1]
    nc = 0 if len (im.shape) < 3 else im.shape[2]
    if aty is None: aty = ny // 2
    if atx is None: atx = nx // 2

    # Work out the region to display.
    ylo = max (aty - rows//2, 0)
    yhi = min (ylo + rows, ny)
    rows = yhi - ylo

    xlo = max (atx - cols//2, 0)
    xhi = min (xlo + cols, nx)
    cols = xhi - xlo

    # Start the output with the title and information about the region.  All
    # our output will be appended to the variable 'text'.
    text = ""
    if not title is None: text += title + "\n"
    channels = "monochrome" if nc == 0 else "%d-channel" % nc
    text += "[%d x %d region of %d x %d-pixel %s image at (%d,%d)]:\n" % \
        (rows, cols, ny, nx, channels, aty, atx)

    # Generate the header line and add it to text.
    start = "       "
    line = ""
    for x in range (xlo, xhi):
        line += "%4d" % x
    text += start + line + "\n" + start + "-" * len (line) + "\n"

    # ASIDE: A monochrome image in OpenCV has two subscripts and a colour one
    # three.  This means one cannot write a single piece of code to iterate
    # over pixels and have it work in both cases.  One can often use numpy's
    # reshape() function to make a monochrome image have three subscripts, or
    # just use whole-array operations; but there are a few occasions where you
    # need to iterate over subscripts explicitly.  This code shows you how.

    # Generate the image output.  We iterate over the rows of the image.  For
    # a monochrome image, we simply output the pixels along each row; but for
    # a colour image, we produce a row for each channel.
    for y in range (ylo, yhi):
        text += "%5d| " % y
        if nc == 0:
            # Monochrome so use two subscripts.
            for x in range (xlo, xhi):
                text += "%4d" % im[y,x]
            text += "\n"
        else:
            # Multi-channel so use three subscripts.
            for c in range (0, nc):
                if c > 0: text += start[:-2] + "| "
                for x in range (xlo, xhi):
                    text += "%4d" % im[y,x,c]
                text += "\n"

    # Return what we have produced, ready to be printed out.
    return text

#-------------------------------------------------------------------------------
def plot_histogram (x, y, title, colours=["blue", "green", "red"]):
    """
    Plot a histogram (bar-chart) of the data in `x` and `y` using
    Matplotlib.  The `y` array can be either a single-dimensional one
    (for the histogram of a monochrome image) or two-dimensional for a
    colour image, in which case the first dimension selects the colour
    band and the second the value in that colour band.  `title` is the
    title of the plot, shown along its top edge.

    Args:
        x (array): numpy array containing the values to plot along the
                   abscissa (x) axis
        y (array): numpy array of the same length as `x` containing the
                   values to plot along the ordinate (y) axis
        title (str): title to put along the top edge of the plot
        colours (list of strings): the colours to use when there is more
                                   than one plot on the axes
                                   (default: blue, green, red)
    """
    # ASIDE: This routine handles monochrome and multi-channel image histogram
    # plotting in essentially the same way as examine did for images.

    # Set up the plot.
    plt.figure ()
    plt.grid ()
    plt.xlim ([0, len (x)])
    plt.xlabel ("grey level")
    plt.ylabel ("frequency")
    plt.title (title)

    # Plot the data.
    if len (y.shape) == 1:
        plt.bar (x, y, color="grey")
    else:
        nc, np = y.shape
        for c in range (0, nc):
            plt.bar (x, y[c], color=colours[c])

    # Show the result.
    plt.show()

#-------------------------------------------------------------------------------
def testimage ():
    """
    Return a test image whose pixels are all in the range 10 to 63.
    It is intended to be used for testing the routines for forming histograms,
    contrast stretching, thresholding and morphological operations.

    Args:
        none

    Returns:
        im (image): numpy structure containing the image

    Tests:
        >>> im = testimage ()
        >>> im.shape
        (13, 10)
    """
    im = numpy.array ([
        [10,   12,   11,   11,   12,   11,   10,   12,   11,   12],
        [10,   10,   10,   10,   10,   10,   10,   10,   10,   11],
        [11,   10,   14,   15,   10,   10,   10,   10,   15,   10],
        [10,   10,   14,   15,   10,   10,   10,   10,   10,   10],
        [10,   10,   14,   14,   10,   10,   10,   10,   10,   10],
        [10,   10,   10,   10,   15,   13,   10,   10,   10,   12],
        [12,   10,   10,   10,   14,   13,   10,   15,   10,   10],
        [12,   10,   10,   10,   10,   14,   10,   14,   14,   11],
        [12,   14,   14,   10,   10,   10,   10,   14,   10,   11],
        [10,   13,   14,   10,   10,   10,   15,   15,   10,   12],
        [12,   14,   15,   10,   10,   10,   10,   10,   10,   10],
        [10,   10,   10,   10,   10,   10,   10,   10,   10,   12],
        [11,   10,   11,   10,   12,   12,   11,   11,   10,   11],
    ], dtype="uint8")
    return im

#-------------------------------------------------------------------------------
def version ():
    """
    Return our version, the date on which it was last edited.

    Args:
        none

    Returns:
        str: the version information as a string
    """
    global TS

    # The content of TS is updated every time Emacs saves the file.  You are
    # encouraged to update the timestamp in the last few lines of this file
    # whenever you make a significant change to it.
    return TS[13:32]

#-------------------------------------------------------------------------------
# LIBRARY ROUTINES.
#-------------------------------------------------------------------------------
def mean (im):
    """
    Return the mean of the pixel values an image.

    Args:
        im (image): image for which the maximum value is to be found

    Returns:
        ave (float): the mean of the image

    Tests:
        >>> ave = mean (arrowhead ())
        >>> print ("OK") if abs (ave - 39.66666666) < 1.0e-5 else print ("bad")
        OK
    """
    return numpy.mean(im)

def highest (im):
    """
    Return the maximum of the pixel values of an image.

    Args:
        im (image): image for which the maximum value is to be found

    Returns:
        hi (of same type as image): highest value in the image

    Tests:
        >>> im = testimage ()
        >>> print (highest (im))
        15
    """
    return numpy.amax(im)

def lowest (im):
    """
    Return the minimum of the pixel values of an image.

    Args:
        im (image): image for which the maximum value is to be found

    Returns:
        lo (of same type as image): lowest value in the image

    Tests:
        >>> im = testimage ()
        >>> print (lowest (im))
        10
    """
    return numpy.amin(im)

def extremes (im):
    """
    Return the minimum and maximum of the pixel values of an image.

    Args:
        im (image): image for which the maximum value is to be found

    Returns:
        lo (of same type as image): lowest value in the image
        hi (of same type as image): highest value in the image

    Tests:
        >>> im = testimage ()
        >>> print (extremes (im))
        [10, 15]
    """
    return "[" + str(lowest(im)) + ", " + str(highest(im)) + "]"

def histogram (im):
    """
    Return a histogram (frequency for each grey level) of the image `im`.
    The maximum pixel value is determined from the image this is use to
    determine the number of grey levels in the plot.

    The first value returned is an array of the grey levels.
    For a monochrome image, the second value returned is a single-index
    array containing the counts for each grey level; but for a colour
    image, it is a two-index array, with the first index selecting the
    channel (colour band) and the second the counts for that band's
    pixel values.

    Args:
        im (image): image for which the histogram is to be produced

    Returns:
        x (int): grey-level values for the abscissa (x) axis
        y (int): frequency counts for the ordinate (y) axis

    Tests:
        >>> im = testimage ()
        >>> x, y = histogram (im)
        >>> print (x)
        [ 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15]
        >>> print (y)
        [ 0  0  0  0  0  0  0  0  0  0 80 13 13  3 13  8]

    """
    levels = highest(im) + 1
    vals = numpy.zeros(levels, dtype=int)
    for i in range(0, levels):
        vals[i] = i

    if len(im.shape) == 2:
        # It's a monochrome image, so we have only one histogram.
        ny, nx = im.shape
        hist = numpy.zeros((levels), dtype=int)
        for y in range(0, ny):
            for x in range(0, nx):
                v = im[y,x]
                hist[v] += 1

    else:
        #It's a multi-channel image, so we have a separate histogram
        #for each of its channels.
        ny, nx, nc = im.shape
        hist = numpy.zeros((nc, levels), dtype=int)

        for y in range(0, ny):
            for x in range(0, nx):
                for c in range(0, nc):
                    v = im[y,x,c]
                    hist[c,v] += 1
    

    return vals, hist

def hsv_to_cv2 (h, s, v):
    """Convert HSV values to the representation used in OpenCV, returning the
    result as a tuple for use in cv2.inRange.

    Args:
        h (float): hue angle in the range zero to 360 degrees
        s (float): saturation percentage
        v (float): value percentage

    Returns:
        hsv (tuple): a tuple of values for use with cv2.inRange

    Tests:
        >>> hsv_to_cv2 (360, 100, 100)
        (180, 255, 255)
    """
    h = round (h / 2)
    s = round(s * 2.55)
    v = round(v * 2.55)
    
    return (h, s, v)

def binarize (im, threshold, below=0, above=255):
    """Threshold monochrome image `im` at value `thresh`, setting pixels
    with value below `thresh` to `below` and those with larger values to
    `above`.  The resulting image is returned.

    Args:
        im (image): image to be thresholded and binarized
        thresh (float): threshold value
        below (float): value to which pixels lower than `thresh` are set
        above (float): value to which pixels greater than `thresh` are set

    Returns:
        bim (image): binarized image

    Tests:
        >>> im = testimage ()
        >>> bim = binarize (im, 12, 7, 25)
        >>> print (bim)
        [[ 7  7  7  7  7  7  7  7  7  7]
         [ 7  7  7  7  7  7  7  7  7  7]
         [ 7  7 25 25  7  7  7  7 25  7]
         [ 7  7 25 25  7  7  7  7  7  7]
         [ 7  7 25 25  7  7  7  7  7  7]
         [ 7  7  7  7 25 25  7  7  7  7]
         [ 7  7  7  7 25 25  7 25  7  7]
         [ 7  7  7  7  7 25  7 25 25  7]
         [ 7 25 25  7  7  7  7 25  7  7]
         [ 7 25 25  7  7  7 25 25  7  7]
         [ 7 25 25  7  7  7  7  7  7  7]
         [ 7  7  7  7  7  7  7  7  7  7]
         [ 7  7  7  7  7  7  7  7  7  7]]
    """
    junk, image = cv2.threshold(im, threshold, above, cv2.THRESH_BINARY)
    image[image == 0] = below
    return image

def largest_contour (contours):
    """Return the largest by area of a set of external contours found by
    OpenCV routine cv2.findContours.

    Args:
        contours (list): list of contours return by cv2.findContours

    Returns:
        contour (contour): a single contour

    Tests:
        >>> im = arrowhead ()
        >>> im[1,1] = 255
        >>> c, junk = cv2.findContours (im, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        >>> lc = largest_contour (c)
        >>> print (cv2.contourArea (lc))
        5.0
    """
    a_max = -1
    c_max = None
    for c in contours:
        a = cv2.contourArea (c)
        if a > a_max:
            a_max = a
            c_max = c
    return c_max

def circularity (c):
    """Return the circularity of the contour `c`, returned from the
    OpenCV routine cv2.findContours.

    Args:
        c (contour): contours returned by cv2.findContours

    Returns:
        circ (float): the circularity of contour c

    Tests:
        >>> im = arrowhead ()
        >>> c, junk = cv2.findContours (im, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        >>> lc = largest_contour (c)
        >>> print ("%.4f" % circularity (lc))
        68.3411
    """
    perimeter = cv2.arcLength (c, True)
    area = cv2.contourArea (c)
    return perimeter**2 / area

def rectangularity (c):
    """Return the rectangularity of the contour `c`, returned from the
    OpenCV routine cv2.findContours.

    Args:
        c (contour): contours returned by cv2.findContours

    Returns:
        rec (float): the rectangularity of contour c

    Tests:
        >>> im = arrowhead ()
        >>> c, junk = cv2.findContours (im, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        >>> lc = largest_contour (c)
        >>> print ("%.4f" % rectangularity (lc))
        4.8276
    """
    rectangle = cv2.minAreaRect(c)
    pos, box, ang = rectangle
    w, h, = box
    area = cv2.contourArea (c)
    return w * h / area
#-------------------------------------------------------------------------------
# EPILOGUE.
#-------------------------------------------------------------------------------
TS = "Time-stamp: <2023-01-11 10:53:50 Adrian F Clark (alien@essex.ac.uk)>"

# Local Variables:
# time-stamp-line-limit: -10
# End:
#-------------------------------------------------------------------------------
# "That's all, folks!"
#-------------------------------------------------------------------------------
