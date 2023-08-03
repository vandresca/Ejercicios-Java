package test;

import org.junit.Assert;
import org.junit.Test;

import src.PseudoAleatoryNumber;

public class TestPseudoAleatoryNumber {

    @Test
    public void checkNumberIsInRange(){
        String numberInStringFormat = String.valueOf(PseudoAleatoryNumber.randomInt());
        Assert.assertTrue(numberInStringFormat.matches("^([0-9]|[1-9][0-9]|100)$"));
    }
}
