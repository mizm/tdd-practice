package com.example.ladder;

// 1급 컬렉션
public class Row {
    private int[] persons;

    public Row(int noOfPerson) {
        this.persons = new int[noOfPerson];
    }

    public void draw(int start) {
        persons[start] = 1;
        persons[start + 1] = 1;
    }
    public int moveRow(int no) {
        if(isNoLine(persons[no])) {
            return no;
        }
        if(isNotLeftEnd(no) && canLeft(persons[no - 1])) {
            return --no;
        }
        return ++no;
    }

    private boolean canLeft(int person) {
        return person == 1;
    }

    private boolean isNotLeftEnd(int no) {
        return no - 1 >= 0;
    }

    private boolean isNoLine(int person) {
        return person == 0;
    }
}
