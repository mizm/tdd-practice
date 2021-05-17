package com.example.ladder;

public class NaturalNumber {

    private int number;

    public NaturalNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException(String.format("자연 수는 1이상이어야 합니다. 현재 값 : %d",number));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int toArrayIndex() {
        return number-1;
    }
}
