package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import src.LeetLanguage;

public class TestReto1 {
    
    @Test
    public void checkTranslateCharacter(){
        Assert.assertEquals(LeetLanguage.translateText("leet"), "1337");
        Assert.assertEquals(LeetLanguage.translateText("LeET"), "1337");
        Assert.assertEquals(LeetLanguage.translateText("abecedario leet"), "4|33[3|)4|2|0 1337");
        Assert.assertEquals(LeetLanguage.translateText("aBecEDarIO lEET"), "4|33[3|)4|2|0 1337");
    }
}
