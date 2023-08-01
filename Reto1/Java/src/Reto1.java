package src;

/**
 * Transformar un texto o una frase al lenguaje hacker "leet"(1337)
 */
public class Reto1 {

    public static void main(String[] args) {
        Printer.print("Introduce un texto;");
        String inputText = RequestScanner.requestText();
        Printer.print("La cadena resultante es: " +
                LeetLanguage.translateText(inputText));
    }
}

