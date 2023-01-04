package Lab1.Exercise3.Q1;

import Lab1.Exercise3.Q1.SuperImportantClass;
import static Lab1.Exercise3.Q1.SuperImportantClass.superImportantStaticMethod;

public class Main
{
    public static void main (String [] args)
    {
        System.out.println( "1 + static method = " + superImportantStaticMethod(1) );

        SuperImportantClass s = new SuperImportantClass();
        System.out.println( "3 + instance method = " + s.superImportantInstanceMethod(3) );
    }
}
