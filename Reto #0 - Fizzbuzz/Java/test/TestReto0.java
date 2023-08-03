package test;

import org.junit.Assert;
import org.junit.Test;
import src.Reto0;

public class TestReto0 {
    
    @Test
    public void checkBuzz(){
        Assert.assertEquals(Reto0.checkTypeFizzBuzz(3), "Buzz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(4), "Buzz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(20),"Buzz");
        Assert.assertEquals(Reto0.checkTypeFizzBuzz(9), "Buzz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(15), "Buzz");
    }

    @Test
    public void checkFizz(){
        Assert.assertEquals(Reto0.checkTypeFizzBuzz(5), "Fizz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(7), "Fizz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(3), "Fizz");
        Assert.assertEquals(Reto0.checkTypeFizzBuzz(25), "Fizz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(15), "Fizz");
    }

    @Test
    public void checkFizzBuzz(){
        Assert.assertEquals(Reto0.checkTypeFizzBuzz(15), "FizzBuzz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(7), "FizzBuzz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(3), "FizzBuzz");
        Assert.assertEquals(Reto0.checkTypeFizzBuzz(30), "FizzBuzz");
        Assert.assertNotEquals(Reto0.checkTypeFizzBuzz(5), "FizzBuzz");
    }
}
