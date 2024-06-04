import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void testDependencies() {
        System.out.println("Everything works!");

        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testIgnoredTest() {
        System.out.println("Test an ignored test");
    }
}
