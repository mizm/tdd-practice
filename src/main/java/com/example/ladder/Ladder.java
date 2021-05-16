package com.example.ladder;

public class Ladder {

    private int[][] rows;

    public Ladder(int countOfRow, int noOfPerson) {
        rows = new int[countOfRow][noOfPerson];
    }

    public int run(int no) {
        for (int i = 0; i < rows.length; i++) {
           int[] row = rows[i];
           if(row[no] == 0) {
               continue;
           }
           if(no - 1 >= 0) {
               int leftValue = row[no - 1];
               if( leftValue == 1) {
                   no--;
                   continue;
               }
           }
           no++;
        }
        return no;
    }

    public void drawLine(int noOfRow, int start) {
        rows[noOfRow][start] = 1;
        rows[noOfRow][start + 1] = 1;
    }
}
