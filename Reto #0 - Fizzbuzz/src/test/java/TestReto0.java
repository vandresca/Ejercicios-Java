import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vandresca.BuzzRule;
import com.vandresca.FizzBuzz;
import com.vandresca.FizzRule;
import com.vandresca.IRule;

public class TestReto0 {
    
    FizzBuzz fizzbuzz;


    @Before
    public void testBefore(){
        IRule[] rules = {new FizzRule(), new BuzzRule()};
        fizzbuzz = new FizzBuzz(rules);
    }

    @Test
    public void checkBuzz(){
        Assert.assertEquals(fizzbuzz.getValueOfNumber(3), "buzz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(4), "buzz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(20),"buzz");
        Assert.assertEquals(fizzbuzz.getValueOfNumber(9), "buzz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(15), "buzz");
    }

    @Test
    public void checkFizz(){
        Assert.assertEquals(fizzbuzz.getValueOfNumber(5), "fizz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(7), "fizz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(3), "fizz");
        Assert.assertEquals(fizzbuzz.getValueOfNumber(25), "fizz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(15), "fizz");
    }

    @Test
    public void checkFizzBuzz(){
        Assert.assertEquals(fizzbuzz.getValueOfNumber(15), "fizzbuzz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(7), "fizzbuzz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(3), "fizzbuzz");
        Assert.assertEquals(fizzbuzz.getValueOfNumber(30), "fizzbuzz");
        Assert.assertNotEquals(fizzbuzz.getValueOfNumber(5), "fizzbuzz");
    }
}
