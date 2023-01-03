package Labs.Lab1.AY2021;

public class SelectPositive implements MyPredicate{
    @Override
    public boolean apply(int value) {
        return value > 0;
    }

    public static void printSelected(int[] list, MyPredicate select){
        for (int element : list)
            if (select.apply(element))
                System.out.println(element);
    }

    public static void main (String[] args){
        int[] list = {1, 2, -5, -4, 0, 6};
        printSelected(list, new SelectPositive());
    }
}
