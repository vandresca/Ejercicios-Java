package com.vandresca;

public class FizzRule implements IRule{
    @Override
    public Boolean check(int number) {
        return number%5==0;
    }

    @Override
    public String getValue() {
        return "fizz";
    }
}
