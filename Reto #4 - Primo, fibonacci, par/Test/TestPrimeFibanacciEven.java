import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPrimeFibanacciEven {
    PrimeFibonacciEven primeFibonacciEven;


    @Before
    public void testBefore(){
        primeFibonacciEven = new PrimeFibonacciEven();
    }

    @After
    public void testAfter(){
        primeFibonacciEven = null;
    }
    
    
    @Test
    public void isPrime(){
        Assert.assertTrue(primeFibonacciEven.isPrime(13)); 
        Assert.assertTrue(!primeFibonacciEven.isPrime(15)); 
        Assert.assertTrue(primeFibonacciEven.isPrime(17)); 
        Assert.assertTrue(!primeFibonacciEven.isPrime(6)); 
    }

    @Test
    public void isFibonacci(){
        Assert.assertTrue(primeFibonacciEven.isFibonnaci(5)); 
        Assert.assertTrue(!primeFibonacciEven.isFibonnaci(7)); 
        Assert.assertTrue(primeFibonacciEven.isFibonnaci(13)); 
        Assert.assertTrue(!primeFibonacciEven.isFibonnaci(14)); 
    }

    @Test
    public void isEven(){
        Assert.assertTrue(!primeFibonacciEven.isEven(5)); 
        Assert.assertTrue(primeFibonacciEven.isEven(10)); 
        Assert.assertTrue(!primeFibonacciEven.isEven(13)); 
        Assert.assertTrue(primeFibonacciEven.isEven(14)); 
    }

    @Test
    public void makeMessage(){
        Assert.assertEquals(primeFibonacciEven.makeMessage(5), "5 es primo, es fibonacci, es impar");
        Assert.assertEquals(primeFibonacciEven.makeMessage(10), "10 no es primo, no es fibonacci, es par"); 
        Assert.assertEquals(primeFibonacciEven.makeMessage(13), "13 es primo, es fibonacci, es impar"); 
        Assert.assertEquals(primeFibonacciEven.makeMessage(14), "14 no es primo, no es fibonacci, es par"); 
    }
}
