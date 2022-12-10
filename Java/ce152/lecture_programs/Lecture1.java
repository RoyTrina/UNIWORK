package lectures_programs;

public class Lecture1 {

    public static void main(String[] args) {
        integerExamples();
        doubleExamples();
        booleanExamples();
        charExamples();
        stringExamples();
        assignmentExamples();
    }

    public static void integerExamples() {
        System.out.println("42/5 = " + 42 / 5);
        System.out.println("42%5 = " + 42 % 5);
        System.out.println("(42/5)*5 + 42%5 = " + ((42 / 5) * 5 + 42 % 5));
        int twoPower31 = 1;
        for (int i = 0; i < 31; i++)
            twoPower31 *= 2;
        System.out.println("2^31 = " + twoPower31);
        System.out.println("2^31 - 1 = " + (twoPower31 - 1));
        System.out.println("2^32 = " + 2 * twoPower31);
    }

    public static void doubleExamples() {
        System.out.println("1.0 + 0.5 = " + (1.0 + 0.5));
        System.out.println("1.0 – 0.9 = " + (1.0 - 0.9));
        System.out.println("(1.1 * 3.11) = " + (1.1 * 3.11));
        System.out.println("(3.3 / 1.1) = " + (3.3 / 1.1));
        System.out.println("6.0/2.0 = " + (6.0 / 2.0));
        System.out.println("Math.sqrt(2) = " + Math.sqrt(2));
        System.out.println("Math.sqrt(-1) = " + Math.sqrt(-1));
        System.out.println("3.0 + 2 = " + (3.0 + 2));
        double d = 3.7;
        int x = (int) d;
        System.out.println("(int)3.7 = " + x);
        x = (int) Math.round(d);
        System.out.println("Math.round(3.7) = " + x);
        System.out.println();
    }

    // Disable Eclipse Java compiler warnings about comparison of identical
    // values
    public static void booleanExamples() {
        System.out.println("(4==4) = " + (4 == 4) + ", (4==5) = " + (4 == 5));
        System.out.println("(4!=5) = " + (4 != 5) + ", (4!=4) = " + (4 != 4));
        System.out.println("(4<5) = " + (4 < 5) + ", (4<4) = " + (4 < 4));
        System.out.println("(4<=5) = " + (4 <= 5) + ", (5<=4) = " + (5 <= 4));
        System.out.println("(5>4) = " + (5 > 4) + ", (5>5) = " + (5 > 5));
        System.out.println("(4==4) = " + (5 >= 5) + ", (5>=5) = " + (4 >= 5));
        System.out.println();
    }

    public static void charExamples() {
        System.out.println("'\\u00F6' = " + '\u00F6');
        System.out.println("(char)(('a') + 1) = " + (char) (('a') + 1));
        System.out.println();
        char c = 'a';
        System.out.print(c);
        c++;
        System.out.print(c);
        c--;
        System.out.println(c);
    }

    public static void stringExamples() {
        System.out.println("Hello" + "," + " world!");
        System.out.println("Born in " + 1957 + ".");
        System.out.println("40 + 2 = " + 40 + 2);
        System.out.println("40 + 2 = " + (40 + 2));

        String s = "abc def";
        System.out.println("String s = " + s);
        System.out.println("s.charAt(4) = " + s.charAt(4));
        System.out.println("s.endsWith(\"ef\") = " + true);
        System.out.println("s.indexOf('c') = " + s.indexOf('c'));
        System.out.println("s.length() = " + s.length());
        System.out.println("s.substring(2,4) = \"" + s.substring(2, 4) + "\"");
        System.out.println("s.substring(2,4).trim() = \"" + s.substring(2, 4).trim() + "\"");

        System.out.println("Integer.parseInt(\"42\") = " + Integer.parseInt("42"));
        System.out.println("Double.parseDouble(\"6.0\") = " + Double.parseDouble("6.0"));

        String s1 = "abc";
        String s2 = " abc ".trim();
        System.out.println("s1 = \"" + s1 + "\"");
        System.out.println("s2 = \"" + s2 + "\"");
    }

    public static void assignmentExamples() {
        int x, y;
        x = 6;
        y = 7;
        int z = x * y;
        System.out.println("x= " + x + ", y= " + y + ", z= " + z + ", b= " + true);
        x = x + y;
        x = x - y;
        System.out.println("x= " + x + ", y= " + y);
        x = 0;
        System.out.println("x = " + x);
        x++;
        System.out.println("x++;\nx = " + x);
        x--;
        System.out.println("x--;\nx = " + x);
        System.out.println();

    }

}
