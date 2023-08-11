package com.vandresca;

import java.util.Scanner;

public class ScannerRequest {
    static Scanner scanner;

    public static String requestColumn(){
        Printer.print("Introduce la columna:");
        scanner = new Scanner(System.in);
        String column = scanner.nextLine();
        while(!column.matches("[A-Z]+")){
            Printer.print("Columna incorrecta, vuelve a introducirla:");
            column = scanner.nextLine();
        }
        return column;
    }

    public static void close(){
        scanner.close();
    }

}
