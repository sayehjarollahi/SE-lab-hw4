package code;

public class ExpressShipping extends Shipping{

    @Override
    public double getPrice(int weight) {
        return 3.5 * weight;
    }

    @Override
    public void print() {
        System.out.println("The method is express shipping!");
    }
}
