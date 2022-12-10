package lectures_programs;

// affine transformations from user-space coordinates to screen coordinates

public class Plot {
    // dimensions of plotting area with default values
    public static int width = 600, height = 600;

    // dimensions of user-space coordinates with default values
    public static double xmin = 0, xmax = 1, ymin = 0, ymax = 1;


    // transformation of coordinates
    public static int scaleX(double x) {
        return (int) (width * (x - xmin) / (xmax - xmin));
    }

    public static int scaleY(double y) {
        return (int) (height * (ymin - y) / (ymax - ymin) + height);
    }

    public static void setScaleX(double min, double max) {
        xmin = min;
        xmax = max;
    }

    public static void setScaleY(double min, double max) {
        ymin = min;
        ymax = max;
    }

}
