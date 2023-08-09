
import org.junit.Assert;
import org.junit.Test;


public class TestPassAbacusToNumber {
    
    PassAbacusToNumber passAbacusToNumber;

   @Test
   public void testTransformAbacusToNumber(){

    passAbacusToNumber = new PassAbacusToNumber();

    String[] abacus = {
        "O---OOOOOOOO",
        "OOO---OOOOOO",
        "O---OOOOOOOO",
        "OO---OOOOOOO",
        "OOO---OOOOOO",
        "O---OOOOOOOO",
        "OOOOOOO---OO"
        };
    Assert.assertEquals(passAbacusToNumber.transform(abacus),"1.312.317");

    String[] abacus2 = {
        "O---OOOOOOOO",
        "OOO---OOOOOO",
        "---OOOOOOOOO",
        "OO---OOOOOOO",
        "OOOOOOO---OO",
        "OOOO---OOOOO",
        "---OOOOOOOOO"
        };
    
    Assert.assertEquals(passAbacusToNumber.transform(abacus2),"1.302.740");

    String[] abacus3 = {
        "O---OOOOOOOO",
        "O---OOOOOOOO",
        "O---OOOOOOOO",
        "OOOOOOOO---O",
        "OOOOOOOO---O",
        "OOOOOO---OOO",
        "OOO---OOOOOO"
        };
    
    Assert.assertEquals(passAbacusToNumber.transform(abacus3),"1.118.863");

    String[] abacus4 = {
        "OOOO---OOOOO",
        "OOOO---OOOOO",
        "---OOOOOOOOO",
        "OOO---OOOOOO",
        "OOOOOOO---OO",
        "OOOOOOOO---O",
        "OO---OOOOOOO"
        };

    Assert.assertEquals(passAbacusToNumber.transform(abacus4),"4.403.782");

   }  
}
