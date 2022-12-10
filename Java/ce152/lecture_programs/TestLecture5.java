package lectures_programs;

import java.awt.*;

public class TestLecture5 {

    public static void main(String[] args) {
        // System.out.print("Printf example:");
        // System.out.printf("%8.5f", 1.0);
        ballCopyTest();
    }

    public static void ballCopyTest() {
        Ball b1 = new Ball(20, Color.RED);
        Ball b2 = b1.copy();
        System.out.println("b1= " + b1);
        System.out.println("b2= " + b2);
    }

}
