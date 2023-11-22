package code;

public class StandardShipping extends Shipping{


    @Override
    public double getPrice(int weight) {
        return 2.5* weight;
    }
}
