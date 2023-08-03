package src;
/**
 * Listar los números del 1 al 100 ambos incluidos
 * Si el número es múltiplo de 3 sustituir por la palabra 'fizz'
 * Si el número es múltiplo de 5 sustituir por la palabra 'buzz'
 * Si el número es múltiplo de 3 y 5 sustituir por la palabra 'fizzbuzz'
 */
public class Reto0 {
    public static void main(String[] args) {
        for(int i = 0; i<100; i++){
            print(checkTypeFizzBuzz(i));
        }
    }

    public static String checkTypeFizzBuzz(int number){
        if(isFizzBuzz(number)) return "FizzBuzz";
        else if(isBuzz(number)) return "Buzz";
        else if(isFizz(number)) return "Fizz";
        else return String.valueOf(number);
    }

    public static Boolean isBuzz(int number){
        return number%3 == 0;
    }

    public static Boolean isFizz(int number){
        return number%5 == 0;
    }

    public static Boolean isFizzBuzz(int number){
        return number%15 == 0;
    }

    public static void print(String text){
        System.out.println(text);
    }
}
