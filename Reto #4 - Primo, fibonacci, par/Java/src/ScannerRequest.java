import java.util.Scanner;

public class ScannerRequest {
    private static Scanner scanner = null;

    public static int requesInteger(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        String input = scanner.next();
        while(!input.matches("^(?!0)[0-9]+$") || input.length()>9){
            input = scanner.next();
        }
        return Integer.valueOf(input);
    }

    public static void close(){
        scanner.close();
    }
}
