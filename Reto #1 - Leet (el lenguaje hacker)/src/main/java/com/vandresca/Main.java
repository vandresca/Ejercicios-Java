package com.vandresca;

/**
 * Transformar un texto o una frase al lenguaje hacker "leet"(1337)
 */
public class Main {

    public static void main(String[] args) {
        Printer.print("Introduce un texto;");
        String inputText = RequestScanner.requestText();
        RequestScanner.close();
        Printer.print("La cadena resultante es: " +
                LeetLanguage.translateText(inputText));
    }
}

