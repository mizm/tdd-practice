package com.example.ladder;

class Ladder {

    private Row[] rows;

    Ladder(NaturalNumber height, NaturalNumber noOfPerson) {
        rows = new Row[height.getNumber()];
        for (int i = 0; i < height.getNumber(); i++) {
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


    void drawLine(NaturalNumber height, NaturalNumber start) {
        if(height.toArrayIndex() > rows.length - 1) {
            throw new IllegalArgumentException("줄수의 최대치를 넘습니다.");
        }
        rows[height.toArrayIndex()].draw(start);
    }
}
