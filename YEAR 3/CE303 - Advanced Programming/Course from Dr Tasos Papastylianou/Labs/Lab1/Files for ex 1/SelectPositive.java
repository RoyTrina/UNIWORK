package Lab1.Exercise1.Q1;

public class SelectPositive implements MyPredicate {
    @Override
    public boolean apply(int value) {
        return value > 0;
    }
}
