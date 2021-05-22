package com.example.core;

import java.util.Objects;

public class NaturalNumber {
    private int number;
    private static final int INTERVAL = 1;

    public NaturalNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException(String.format("자연 수는 1이상이어야 합니다. 현재 값 : %d",number));
        }
        this.number = number;
    }

    public static NaturalNumber createFromArrayIndex(int index) {
        return new NaturalNumber(index + INTERVAL);
    }

    public int getNumber() {
        return number;
    }

    public int toArrayIndex() {
        return number-INTERVAL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalNumber that = (NaturalNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
