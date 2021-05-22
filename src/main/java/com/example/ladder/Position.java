package com.example.ladder;

import com.example.core.NaturalNumber;

import java.util.Objects;

public class Position {
    private NaturalNumber height;
    private NaturalNumber nthOfPerson;

    private Position(NaturalNumber height, NaturalNumber nthOfPerson) {
        this.height = height;
        this.nthOfPerson = nthOfPerson;
    }

    static Position create(NaturalNumber height, NaturalNumber nthOfPerson) {
        return new Position(height,nthOfPerson);
    }

    static Position create(int height, int nthOfPerson) {
        return new Position(new NaturalNumber(height),new NaturalNumber(nthOfPerson));
    }

    public static Position createFromArrayIndex(int height, int nthOfPerson) {
        return new Position(NaturalNumber.createFromArrayIndex(height)
                , NaturalNumber.createFromArrayIndex(nthOfPerson));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(height, position.height) && Objects.equals(nthOfPerson, position.nthOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, nthOfPerson);
    }
}
