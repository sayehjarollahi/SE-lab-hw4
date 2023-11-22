package code;

public class StandardShipping extends Shipping{


    @Override
    public double getPrice(int weight) {
        return 2.5* weight;
    }

    @Override
    public void print() {
        System.out.println("The method is Standard Shipping!");
    }
}
