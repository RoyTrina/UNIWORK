package lectures_programs;

public class RandomIntCmdLine {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double r1 = Math.random();
        int r2 = (int) (r1 * n);
        System.out.println("random integer is " + r2);
    }
}

