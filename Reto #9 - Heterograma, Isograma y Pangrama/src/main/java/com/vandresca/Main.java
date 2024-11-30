package com.vandresca;

/*
 * Crea 3 funciones, cada una encargada de detectar si una cadena de
 * texto es un heterograma, un isograma o un pangrama.
 * - Debes buscar la definición de cada uno de estos términos.
 */

public class Main{
    public static void main(String[] args) {
        IRule[] rules = {new FizzRule(), new BuzzRule()};
        FizzBuzz fizzbuzz = new FizzBuzz(rules);
        fizzbuzz.generate(100);
    }
}