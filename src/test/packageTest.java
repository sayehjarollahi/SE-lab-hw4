import org.junit.Test;
import static org.junit.Assert.*;

public class packageTest {

    @Test
    public void testCreateClass(){
        Package pkg = new Package(5);
        assertEquals(pkg.getWeight(), 5);
    }
    @Test
    public void testSetShipping(){
        Package pkg = new Package(5);
        Shipping shipping = new StandardShipping();
        pkg.setShipping(shipping);
        double actualPrice = 2.5*5;
        assertEquals(shipping.getShippingPrice(), actualPrice);

        shipping = new ExpressShipping();
        pkg.setShipping(shipping);
        actualPrice = 3.5*5;
        assertEquals(shipping.getShippingPrice(), actualPrice);
    }


}
