package com.example.ladder;

public class Ladder {

    private int[] row;

    public Ladder(int noOfPerson) {
        row = new int[noOfPerson];
    }

    public int run(int no) {
        if(row[no] == 0) {
            return no;
        }

        // left
        if(no - 1 >= 0) {
            int leftValue = row[no - 1];
            if( leftValue == 1) {
                return no - 1;
            }
        }

        return no + 1;
    }

    public void drawLine(int start) {
        row[start] = 1;
        row[start + 1] = 1;
    }
}
