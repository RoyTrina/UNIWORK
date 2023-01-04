package Lab1.Exercise1.Q2;

import Lab1.Exercise1.Q2.MyPredicate;

public class Main
{
    public static void printSelected(int[] list, MyPredicate select){
        for (int element : list)
            if (select.apply(element))
                System.out.println(element);
    }

    public static void main (String[] args){
        int[] list = {1, 2, -5, -4, 0, 6};
        printSelected( list,
                       new MyPredicate () {
                          public boolean apply(int value) {
                              return value > 0;
                          }
                       }
                     );
    }
}
