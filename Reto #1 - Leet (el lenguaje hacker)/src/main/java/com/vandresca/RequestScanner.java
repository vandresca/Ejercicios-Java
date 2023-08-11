package com.vandresca;

import java.util.Scanner;
    
public class RequestScanner {
  static Scanner scanner = null;      
  
  public static String requestText(){
    if(scanner == null){
      scanner = new Scanner(System.in);
    }
    String inputText = scanner.nextLine();
    while(!inputText.matches("[A-Za-z0-9]+")){
      inputText= scanner.nextLine();
    }
    return inputText;
  }

  public static void close(){
    scanner.close();
  }

}
