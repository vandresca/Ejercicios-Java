package src;

import java.util.Scanner;

    public class RequestScanner {
      
      public static String requestText(){
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        input.close();
        return inputText;
      }
}
