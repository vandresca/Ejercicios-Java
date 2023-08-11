import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.vandresca.PasswordGenerator;

public class TestReto3 {
    
    @Test
    public void generatePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        PasswordGenerator.Params.hasLength16 = true;
        PasswordGenerator.Params.hasUpperCase = false;
        PasswordGenerator.Params.hasNumbers = false;
        PasswordGenerator.Params.hasSymbols = false;
        String password = passwordGenerator.generatePassword();
        Assert.assertEquals(password.length(),16);
        Assert.assertTrue(password.matches("[a-z]+"));

        PasswordGenerator.Params.hasLength16 = true;
        PasswordGenerator.Params.hasUpperCase = true;
        PasswordGenerator.Params.hasNumbers = false;
        PasswordGenerator.Params.hasSymbols = false;
        password = passwordGenerator.generatePassword();
        Assert.assertEquals(password.length(),16);
        Assert.assertTrue(password.matches("[a-zA-Z]+"));

        PasswordGenerator.Params.hasLength16 = true;
        PasswordGenerator.Params.hasUpperCase = true;
        PasswordGenerator.Params.hasNumbers = true;
        PasswordGenerator.Params.hasSymbols = false;
        password = passwordGenerator.generatePassword();
        Assert.assertEquals(password.length(),16);
        Assert.assertTrue(password.matches("[a-zA-Z0-9]+"));

        PasswordGenerator.Params.hasLength16 = true;
        PasswordGenerator.Params.hasUpperCase = true;
        PasswordGenerator.Params.hasNumbers = true;
        PasswordGenerator.Params.hasSymbols = true;
        password = passwordGenerator.generatePassword();
        Assert.assertEquals(password.length(),16);
        boolean hasSymbols = Pattern.compile("[A-Za-z0-9" + CharMatcher.inRange('!', '~').toString() + "]+").matcher(password).find();
        Assert.assertTrue(hasSymbols);        
    }
}
