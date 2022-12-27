package labs.lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {
    // --Commented out by Inspection (08/08/2021 23:35):ArrayList<Integer>list;

    public static void maximum(ArrayList<Integer>list){
        System.out.println("Enter the integers: ");
        Scanner input = new Scanner(System.in);

        Integer item = input.nextInt();
        list.add(item);

        for (int i = 0; i < list.size() && list.size() == 10; i++){
            System.out.println(list.get(i));
        }
    }

    public static void minimum(ArrayList<Integer>list){
        System.out.println("Enter the integers: ");
        Scanner input = new Scanner(System.in);

        Integer item = input.nextInt();
        list.add(item);

        for (int i = 0; i < list.size() && list.size() == 10; i++){
            System.out.println(list.get(i));
        }
    }

// --Commented out by Inspection START (08/08/2021 23:35):
//    public static double average(ArrayList<Integer>list){
//        System.out.println("Enter the integers: ");
//        Scanner input = new Scanner(System.in);
//
//        Integer item = input.nextInt();
//        list.add(item);
//
//        for (int i = 0; i < list.size() && list.size() == 10; i++){
//            System.out.println(list.get(i));
//        }
//        return 0;
//    }
// --Commented out by Inspection STOP (08/08/2021 23:35)
}
