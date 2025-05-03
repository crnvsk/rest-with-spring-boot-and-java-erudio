package br.com.crnvsk.request.converters;

import br.com.crnvsk.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNum) throws IllegalArgumentException {
        if(strNum == null || strNum.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String num = strNum.replace(",", ".");
        return Double.parseDouble(num);
    }

    public static boolean isNumeric(String strNum) {
        if(strNum == null || strNum.isEmpty()) return false;
        String num = strNum.replace(",", ".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
