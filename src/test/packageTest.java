import org.junit.Test;
import static org.junit.Assert.*;

public class packageTest {

    @Test
    public void testCreateClass(){
        Package pkg = new Package(5);
        assertEquals(pkg.getWeight(), 5);
    }

}
