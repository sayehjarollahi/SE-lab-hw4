package code;

public class ExpressShipping extends Shipping{

    @Override
    public double getPrice(int weight) {
        return 2.5 * weight;
    }
}
