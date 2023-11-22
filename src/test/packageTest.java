import org.junit.Test;
import code.Package;
import code.*;

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
        assertEquals(pkg.getShippingPrice(), actualPrice);

        shipping = new ExpressShipping();
        pkg.setShipping(shipping);
        actualPrice = 3.5*5;
        assertEquals(pkg.getShippingPrice(), actualPrice);
    }


    @Test
    public void testSendPackage(){
        Package pkg = new Package(5);
        Shipping shipping = new StandardShipping();
        pkg.setShipping(shipping);
        assertEquals(pkg.getState().getClass(), InTransitState.class);
        pkg.send();
        assertEquals(pkg.getState().getClass(), DeliveredState.class);
    }


}
