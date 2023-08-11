package com.vandresca;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]|,./?><";

    public static class Params{
        public static Boolean hasLength16;
        public static Boolean hasUpperCase;
        public static Boolean hasNumbers;
        public static Boolean hasSymbols;
    }

    public void run(){
        requestParams();
        showPassword(generatePassword());
    }

    private void requestParams(){
        Printer.print("¿Quieres que la contraseña sea de longitud 16? [Escribe 'true' o 'false']");
        Params.hasLength16 = ScannerRequest.requestBoolean();
        Printer.print("¿Quieres que la contraseña contenga también mayúsculas? [Escribe 'true' o 'false']");
        Params.hasUpperCase = ScannerRequest.requestBoolean();    
        Printer.print("¿Quieres que la contraseña contenga también números? [Escribe 'true' o 'false']");
        Params.hasNumbers = ScannerRequest.requestBoolean();
        Printer.print("¿Quieres que la contraseña contenga también símbolos? [Escribe 'true' o 'false']");
        Params.hasSymbols = ScannerRequest.requestBoolean();
        ScannerRequest.close();
    }

    public String generatePassword() {
        String sourceChars = getSourceChars();
        int length = (Params.hasLength16)? 16 : 8;
        String password = "";
        for(int i=0; i<length; i++){
            password += randomChar(sourceChars);
        }
        return password;
    }

    private static String randomChar(String sourceChars){
        Random rd = new Random();
        int randomInt = rd.nextInt(sourceChars.length());
        return String.valueOf(sourceChars.charAt(randomInt));
    }

    private static void showPassword(String password){
        System.out.println(password);
    }

    private static String getSourceChars(){
        StringBuilder sourceChars = new StringBuilder(LOWERCASE);
        if(Params.hasUpperCase){
            sourceChars.append(UPPERCASE);
        }
        if(Params.hasNumbers){
            sourceChars.append(NUMBERS);
        }
        if(Params.hasSymbols){
            sourceChars.append(SYMBOLS);
        }
        List<String> source = Arrays.asList(sourceChars.toString());
        Collections.shuffle(source);
        return source.get(0);
    }
}
