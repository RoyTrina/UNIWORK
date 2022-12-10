package Assignment2019;
//Date of backup: 14/12/2019

import java.util.TreeSet;

public class Exercise4 {
    public static void partA() {
        Vehicle va = new Vehicle();
        Vehicle vb = new Vehicle("car", 60.0);
        vb.speedUp();
        System.out.println(va.type + " " + va.speed);
        System.out.println(vb.type + " " + vb.speed);
    }

    public static void partB() {
        String[] typeArray = {"car", "train", "plane", "bicycle",};
        double[] speedArray = {60, 180, 1000, 20};
        TreeSet vehicles = new TreeSet<>();
        for (int i = 0; i < typeArray.length; i++) {
            vehicles.add(new Vehicle(typeArray[i], speedArray[i]));
        }
    }

    public static void main(String[] args) {
        //partA();
        partB();
    }
}