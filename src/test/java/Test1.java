import org.testng.annotations.Test;
import  org.testng.Assert;

public class Test1 {

    @Test
    public  void  test1()
    {

        String actual = "Hello World";
        Assert.assertEquals("Hello World", actual);

    }

}
