package code;

public class Package {
    private int weight;
    private Shipping shipping;
    private State state;

    public Package(int weight){
        this.weight = weight;
        this.state = new InTransitState();
    }

    public int getWeight(){
        return this.weight;
    }

    public void setShipping(Shipping shipping){
        shipping.print();
        this.shipping = shipping;
    }

    public double getShippingPrice(){
        return shipping.getPrice(this.weight);
    }

    public State getState(){
        return this.state;
    }

    public void send(){
        this.state = new DeliveredState();

    }


}
