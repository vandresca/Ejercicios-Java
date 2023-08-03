import java.lang.reflect.Method;
import org.junit.Assert;
import org.junit.Test;

import src.PasswordGenerator;



public class TestPasswordGenerator {
    
    @Test
    public void generatePassword(){
        try{
            PasswordGenerator passwordGenerator = new PasswordGenerator();
            Method generatePassword = PasswordGenerator.class.getDeclaredMethod("generatePassword");
            generatePassword.setAccessible(true);

            PasswordGenerator.Params.hasLength16 = true;
            PasswordGenerator.Params.hasUpperCase = false;
            PasswordGenerator.Params.hasNumbers = false;
            PasswordGenerator.Params.hasSymbols = false;

            String password = (String)generatePassword.invoke(passwordGenerator);
            Assert.assertEquals(password.length(),16);
            Assert.assertTrue(password.matches("[a-z]+"));

            PasswordGenerator.Params.hasLength16 = true;
            PasswordGenerator.Params.hasUpperCase = true;
            PasswordGenerator.Params.hasNumbers = false;
            PasswordGenerator.Params.hasSymbols = false;

            password = (String)generatePassword.invoke(passwordGenerator);
            Assert.assertEquals(password.length(),16);
            Assert.assertTrue(password.matches("[a-zA-Z]+"));

            PasswordGenerator.Params.hasLength16 = true;
            PasswordGenerator.Params.hasUpperCase = true;
            PasswordGenerator.Params.hasNumbers = true;
            PasswordGenerator.Params.hasSymbols = false;

            password = (String)generatePassword.invoke(passwordGenerator);
            Assert.assertEquals(password.length(),16);
            Assert.assertTrue(password.matches("[a-zA-Z0-9]+"));

            PasswordGenerator.Params.hasLength16 = true;
            PasswordGenerator.Params.hasUpperCase = true;
            PasswordGenerator.Params.hasNumbers = true;
            PasswordGenerator.Params.hasSymbols = true;

            password = (String)generatePassword.invoke(passwordGenerator);
            Assert.assertEquals(password.length(),16);
            Assert.assertTrue(!password.matches("([a-zA-Z0-9!@#$%^&*()_+-=[]|,./?><]+)"));

            generatePassword.setAccessible(false);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
