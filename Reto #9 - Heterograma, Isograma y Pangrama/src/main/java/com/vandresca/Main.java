package com.vandresca;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

/*
 * Crea 3 funciones, cada una encargada de detectar si una cadena de
 * texto es un heterograma, un isograma o un pangrama.
 * - Debes buscar la definición de cada uno de estos términos.
 */

public class Main{
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine().toUpperCase();
        word = word.replaceAll("[^a-zA-Z]", "");
        
        HashSet<Character> letters = new HashSet<>();
        HashSet<Character> alphabet = new HashSet<>();
        boolean isIsogram = false;
          
        for(char c: word.toCharArray()){
            if(Character.isLetter(c)){
                alphabet.add(c);
            }
                
            if(!letters.add(c)){
                isIsogram = true;
            }
        }

        if(alphabet.size()==26){
            System.out.println("Es un pangrama");
        }else{
            if(isIsogram){
                System.out.println("Es un isograma.");
            }else{
                System.out.println("Es un heterograma");
            }
        }
    }
}