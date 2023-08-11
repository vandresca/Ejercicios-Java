package Java.test;

import org.junit.Assert;
import org.junit.Test;

import com.vandresca.FindNumberColumn;


public class TestReto32 {

    @Test
    public void testFindNumberOfColumn(){     
        Assert.assertEquals(FindNumberColumn.run("A"),1);
        Assert.assertEquals(FindNumberColumn.run("Z"),26);
        Assert.assertEquals(FindNumberColumn.run("AA"),27);
        Assert.assertEquals(FindNumberColumn.run("CA"),79);
        Assert.assertEquals(FindNumberColumn.run("AAA"),703);
        Assert.assertEquals(FindNumberColumn.run("AXKDJE"),23045105);
    }
}
