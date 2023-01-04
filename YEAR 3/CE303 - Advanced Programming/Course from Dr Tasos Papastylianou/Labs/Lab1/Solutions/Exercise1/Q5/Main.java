package Lab1.Exercise1.Q5;

import java.util.function.Predicate;

public class Main
{
    public static void printSelected(int[] list, Predicate<Integer> select){
        for (int element : list)
            if (select.test(element))
                System.out.println(element);
    }

    public static void main (String[] args){
        int[] list = {1, 2, -5, -4, 0, 6};
        printSelected( list, x -> x > 0 );
    }
}
