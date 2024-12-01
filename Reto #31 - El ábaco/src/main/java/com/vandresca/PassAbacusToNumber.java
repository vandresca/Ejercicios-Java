package com.vandresca;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class PassAbacusToNumber {
    public String transform(String[] abacus){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(abacus).forEach(line -> {
            stringBuilder.append(line.indexOf("---"));
        });
        return formatNumber(stringBuilder.toString());
    }

    private static String formatNumber(String number){
        Locale locale = new Locale.Builder().setLanguage("es").
            setRegion("ES").build();
        NumberFormat formatter = NumberFormat.getInstance(locale);
        return formatter.format(Long.valueOf(number.toString()));
    }
}
