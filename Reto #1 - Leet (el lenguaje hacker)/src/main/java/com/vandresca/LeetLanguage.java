package com.vandresca;

public class LeetLanguage {

    private  static String[] normalAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " "};

    private static String[] leetAlphabet = {"4", "|3", "[", "|)", "3", "|=", "6", "/-/","|", "_/",
            "|<", "1", "|v|", "|\\|", "0", "/>", "0,", "|2", "5", "7", "|_|", "\\/", "\\/\\/", "><","j", "2",
            "O", "L" ,"R", "E", "A", "S", "b", "T", "B", "g", " "};
    
    private static final String EMPTY_STRING = "";


    public static String translateText(String inputText){
        inputText = inputText.toUpperCase();
        String outputText = "";
        for(int i=0; i<inputText.length(); i++){
            outputText += translateCharacter(inputText.charAt(i));
        }
        return outputText;
    }

    private static String translateCharacter(Character character){
        for(int i=0; i<normalAlphabet.length; i++){
            if(normalAlphabet[i].equals(character.toString())){
                return leetAlphabet[i];
            }
        }
        return EMPTY_STRING;
    }
}
