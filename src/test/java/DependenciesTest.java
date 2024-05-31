import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void testDependencies() {
        System.out.println("Everything works!");

        Assert.assertTrue(true);
    }

    @Test
    public void testFalse() {

        Assert.fail();
    }
}
