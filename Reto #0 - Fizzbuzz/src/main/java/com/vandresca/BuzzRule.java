package com.vandresca;

public class BuzzRule implements IRule{
    @Override
    public Boolean check(int number) {
        return number%3==0;
    }

    @Override
    public String getValue() {
        return "buzz";
    }
}     
