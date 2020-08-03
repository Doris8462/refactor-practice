package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int count(String method){
        int countEven = 0,countOdd=0,countPositive=0,countNegative=0;
        for (int number : numbers) {
            if(number%2==1) countOdd++;
            else countEven++;

            if (number < 0) countNegative++;
            else  countPositive++;
        }
        switch (method){
            case "Even":return countEven;
            case "Odd":return countOdd;
            case "Positive":return countPositive;
            case "Negative":return countNegative;
        }
        return 0;
    }
}
