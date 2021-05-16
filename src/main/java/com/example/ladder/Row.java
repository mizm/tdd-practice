package com.example.ladder;

// 1급 컬렉션
public class Row {
    private int[] persons;

    public Row(int noOfPerson) {
        this.persons = new int[noOfPerson];
    }

    public void draw(int start) {
        persons[start] = 1;
        persons[start + 1] = -1;
    }

    public int move(int no) {
        if(isNoLine(no)) {
            return no;
        }

        if(isLeft(no)) {
            return ++no;
        }
        return --no;
    }

    private boolean isLeft(int no) {
        return persons[no] == 1;
    }

    private boolean isNoLine(int no) {
        return persons[no] == 0;
    }
}
