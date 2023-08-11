import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.vandresca.BuzzRule;
import com.vandresca.FizzBuzz;
import com.vandresca.FizzRule;
import com.vandresca.IRule;

public class TestReto0 {
    
    FizzBuzz fizzbuzz;


    @BeforeAll
    public void testBefore(){
        IRule[] rules = {new FizzRule(), new BuzzRule()};
        fizzbuzz = new FizzBuzz(rules);
    }

    @Test
    public void checkBuzz(){
        Assertions.assertEquals(fizzbuzz.getValueOfNumber(3), "buzz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(4), "buzz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(20),"buzz");
        Assertions.assertEquals(fizzbuzz.getValueOfNumber(9), "buzz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(15), "buzz");
    }

    @Test
    public void checkFizz(){
        Assertions.assertEquals(fizzbuzz.getValueOfNumber(5), "fizz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(7), "fizz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(3), "fizz");
        Assertions.assertEquals(fizzbuzz.getValueOfNumber(25), "fizz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(15), "fizz");
    }

    @Test
    public void checkFizzBuzz(){
        Assertions.assertEquals(fizzbuzz.getValueOfNumber(15), "fizzbuzz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(7), "fizzbuzz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(3), "fizzbuzz");
        Assertions.assertEquals(fizzbuzz.getValueOfNumber(30), "fizzbuzz");
        Assertions.assertNotEquals(fizzbuzz.getValueOfNumber(5), "fizzbuzz");
    }
}
