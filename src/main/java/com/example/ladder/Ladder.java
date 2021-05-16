package com.example.ladder;

public class Ladder {

    private int[] row;

    public Ladder(int noOfPerson) {
        row = new int[noOfPerson];
    }

    public int run(int no) {
        if(no - 1 <= 0 && row[no - 1] == 1) {
            return no + 1;
        }
        if(row[no - 1] == 1) {
            if(row[no - 2] == 1) {
                return no - 1;
            }

            if(row[no] == 1) {
                return no + 1;
            }
        }
        return no;
    }

    public void drawLine(int start) {
        row[start] = 1;
        row[start + 1] = 1;
    }
}
