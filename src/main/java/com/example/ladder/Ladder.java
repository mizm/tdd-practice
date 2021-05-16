package com.example.ladder;

public class Ladder {

    private Row[] rows;

    public Ladder(int countOfRow, int noOfPerson) {
        rows = new Row[countOfRow];
        for (int i = 0; i < countOfRow; i++) {
            rows[i] = new Row(noOfPerson);
        }

    }

    public int run(int no) {
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            no = row.move(no);
        }
        return no;
    }

    public void drawLine(int noOfRow, int start) {
        rows[noOfRow].draw(start);
    }
}
