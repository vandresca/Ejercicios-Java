package Reto7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.RowFilter.Entry;

/*
 * Crea un programa que simule el comportamiento del sombrero selccionador del
 * universo mágico de Harry Potter.
 * - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
 * - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
 * - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que
 *   coloque al alumno en una de las 4 casas de Hogwarts:
 *   (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
 * - Ten en cuenta los rasgos de cada casa para hacer las preguntas
 *   y crear el algoritmo seleccionador:
 *   Por ejemplo, en Slytherin se premia la ambición y la astucia.
 */

class HatQuestion {
    String question;
    Answer[] answers;

    public HatQuestion(String question, Answer[] answers) {
        this.question = question;
        this.answers = answers;
    }
}

class Answer{
    String answer;
    String house;
    public Answer(String answer, String house){
        this.answer = answer;
        this.house = house;
    }
}

class ScannerRequest{

    private static Scanner scanner = null;

    public static int requestText() {
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        int input =scanner.nextInt();
        return input;
    }

    public static void close(){
        scanner.close();
    }
}

public class Reto7 {
    static HatQuestion[] hatQuestions = new HatQuestion[] {
            new HatQuestion("(1) - ¿Cómo te definirías?", new Answer[] {
                    new Answer("\t1. Valiente", "gryffindor"),
                    new Answer("\t2. Leal", "hufflepuff"),
                    new Answer("\t3. Sabio", "ravenclaw"),
                    new Answer("\t4. Ambicioso", "slytherin") }),
            new HatQuestion("(2) - ¿Cuál es tu clase favorita?", new Answer[] {
                    new Answer("\t1. Vuelo", "gryffindor"),
                    new Answer("\t2. Pociones", "ravenclaw"),
                    new Answer("\t3. Defensa contra las artes oscuras", "slytherin"),
                    new Answer("\t4. Animales fantásticos", "hufflepuff") }),
            new HatQuestion("(3) - ¿Dónde pasarías más tiempo?", new Answer[] {
                    new Answer("\t1. Invernadero", "hufflepuff"),
                    new Answer("\t2. Biblioteca", "ravenclaw"),
                    new Answer("\t3. En la sala común", "slytherin"),
                    new Answer("\t4. Explorando", "gryffindor") }),
            new HatQuestion("(4) - ¿Cuál es tu color favorito?", new Answer[] {
                    new Answer("\t1. Rojo", "gryffindor"),
                    new Answer("\t2. Azul", "ravenclaw"),
                    new Answer("\t3. Verde", "slytherin"),
                    new Answer("\t4. Amarillo", "hufflepuff") }),
            new HatQuestion("(5) - ¿Cuál es tu mascota?", new Answer[] {
                    new Answer("\t1. Sapo", "ravenclaw"),
                    new Answer("\t2. Lechuza", "gryffindor"),
                    new Answer("\t3. Gato", "hufflepuff"),
                    new Answer("\t4. Serpiente", "slytherin") })
    };

    static HashMap<String, Integer> houses = new HashMap<String, Integer>();


    static int questionsDone = 0;

    public static void main(String[] args) {
        int questionNumber = 0;
        houses.put("gryffindor", 0);
        houses.put("hufflepuff", 0);
        houses.put("ravenclaw", 0);
        houses.put("slytherin", 0);
        
        while(!hasEnd()){
            showQuestion(questionNumber);     
            int input = ScannerRequest.requestText();
            if(!isValidAnswer(input)){ 
                continue;
            }else{
                String house = hatQuestions[questionNumber].
                    answers[input-1].house;
                houses.put(house, houses.get(house) + 1);
                questionNumber++;
                questionsDone++;
            }
            
        }

        ScannerRequest.close();

        print("Lo tengo claro ¡"+ getHouseMoreVoted()+"!");
    }

    private static Boolean hasEnd() {
        return questionsDone == 5;
    }

    private static String getHouseMoreVoted(){
        String maxScoredHouse = "gryffindor";
        int maxScored = 0;
        
        for(String house: houses.keySet()){
            if(houses.get(house) > maxScored){
                maxScoredHouse = house;
                maxScored = houses.get(house);
            }
        }
        return maxScoredHouse;
    }

    private static void showQuestion(int questionNumber){
        print(hatQuestions[questionNumber].question);
        print(hatQuestions[questionNumber].answers[0].answer);
        print(hatQuestions[questionNumber].answers[1].answer);
        print(hatQuestions[questionNumber].answers[2].answer);
        print(hatQuestions[questionNumber].answers[3].answer);
    }


   

    private static Boolean isValidAnswer(int answer) {
        if (1 == answer || 2 == answer
                || 3 ==answer || 4 == answer) {
            return true;
        } else {
            return false;
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
