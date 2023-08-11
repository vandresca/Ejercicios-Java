package com.vandresca;

/*
 * Escribe un programa que, dado un número, compruebe y muestre si es primo,
 * fibonacci y par.
 * Ejemplos:
 * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
 * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
*/
public class Main {

    public static void main(String[] args) {
        Printer.print("Escribe el número que quieres comprobar: ");
        int number = ScannerRequest.requesInteger();
        PrimeFibonacciEven primeFibonacciEven = new PrimeFibonacciEven();
        Printer.print(primeFibonacciEven.makeMessage(number));               
    }
}
