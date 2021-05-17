package com.example.ladder;

class Ladder {

    private Row[] rows;

    Ladder(int countOfRow, int noOfPerson) {
        rows = new Row[countOfRow];
        for (int i = 0; i < countOfRow; i++) {
            rows[i] = new Row(noOfPerson);
        }

    }

    int run(int no) {
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            no = row.move(no);
        }
        return no;
    }

    void drawLine(int noOfRow, int start) {
        rows[noOfRow].draw(start);
    }
}
