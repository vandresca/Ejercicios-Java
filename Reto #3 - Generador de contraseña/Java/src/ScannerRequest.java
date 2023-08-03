package src;
import java.util.Scanner;

public class ScannerRequest {
    private static Scanner scanner = null;
    
    public static Boolean requestBoolean(){
        String input;
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        input = scanner.next();
        while(!("false".equals(input) || "true".equals(input))) {
            input = scanner.next();
        }
        return Boolean.parseBoolean(input); 
    }

    public static void close(){
        scanner.close();
    }
}
