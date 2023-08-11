package com.vandresca;

public class FizzBuzz {
    private IRule[] rules;

    public FizzBuzz(IRule[] rules){
        this.rules=rules;
    }

    public void generate(int length){
        for(int i=1; i<=length; i++){
            System.out.println(getValueOfNumber(i));
        }
    }

    public String getValueOfNumber(int number){
        String value = "";
        for(IRule rule: rules){
            if(rule.check(number)){
                value += rule.getValue();
            }
        }
        return ((value=="")?String.valueOf(number):value);
    }
}
