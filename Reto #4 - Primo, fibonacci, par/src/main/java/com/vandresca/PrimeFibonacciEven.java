package com.vandresca;


public class PrimeFibonacciEven {
    
    public String makeMessage(int input){
        StringBuilder message = new StringBuilder();
        message.append(String.valueOf(input));
        message.append((isPrime(input)? " es primo,":" no es primo,"));
        message.append((isFibonnaci(input)?" es fibonacci,":" no es fibonacci,"));
        message.append(isEven(input)?" es par":" es impar");
        return message.toString();
    }

    public Boolean isPrime(int number){
        for(int i=2; i<number; i++){
            if(number%i==0) return false;
        }     
        return true;
    }

    public Boolean isFibonnaci(int number){
        int fibonnaci=1;
        int number1 = 0;
        int number2 = 1;
        while(fibonnaci < number){
            fibonnaci =number1 + number2;
            number1= number2;
            number2= fibonnaci;
        }
        return (fibonnaci == number);
    }

    public Boolean isEven(int number){
        return (number%2==0);
    }
}
