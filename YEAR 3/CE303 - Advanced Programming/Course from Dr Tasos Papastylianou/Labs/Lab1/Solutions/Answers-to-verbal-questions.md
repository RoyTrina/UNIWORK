# Lab 1. Introduction to advanced programming with Java.

## Part 1

### Exercise 1

#### Q1.1:

The name of the file should be `MyPredicate.java`.

This is because we declared the interface as `public`. When a class (or
interface) is declared `public`, java expects the file to have the same name as
the class (or interface) we just defined. This also means there can only be
_one_ public class (or interface) in any `.java` file.

This enables java to resolve references in your code to public classes by using 
the filename of the public class directly (and compile these files too if not
already compiled). Otherwise, java will not know in which file to find a
reference to a class, and will therefore expect you to have pre-compiled and
generated all the necessary `.class` files separately.


#### Q1.2:

If your root folder is:

    /home/tasos/Desktop/CE303/

then the file should be placed in

    /home/tasos/Desktop/CE303/Lab1/Exercise1/Q1/MyPredicate.java

and then when you compile or run this code, you should do so from the root
folder.

### Exercise 3

#### Q1.1

The 'classpath' tells the java compiler where to find packages/classes.

If no classpath is provided, the java compiler will only look in the default
folder (which is the "current" folder), and expect to find all package directory
hierarchies present there directly.

Setting a classpath as a list of "colon-separated" directories (or
"semicolon-separated" in windows), gives the java compiler a list of places to
look for classes, other than the current directory.

The classpath definition can also contain `.jar` files instead of directories:
.jar files are effectively special archives containing code. Adding a jar file
on the classpath effectively 'loads' the jar file as a directory, to look for
packages/classes inside it as needed for compilation.

In this case, because we're dealing with a .jar file, we had to add it to the
classpath explicitly. Alternatively, if we wanted to avoid setting an explicit
classpath, we could have also extracted the relevant package directories
from the .jar file, and put them on the root directory.


#### Q1.2

If no classpath is specified, the classpath is set to the default option, which
is the 'current directory'. However, if one _does_ set a directory on the
classpath, if you need the current directory (i.e. `.`) to _also_ be included in
the list of places where java will look for packages/classes, then you need to
add it explicitly. This is why our classpath was `.:junit.jar` rather than just
`junit.jar`.
