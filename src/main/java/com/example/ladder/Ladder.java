package com.example.ladder;

import com.example.core.NaturalNumber;

class Ladder {

    private Row[] rows;

    Ladder(NaturalNumber height, NaturalNumber noOfPerson) {
        rows = new Row[height.getNumber()];
        for (int i = 0; i < height.getNumber(); i++) {
            rows[i] = new Row(noOfPerson);
        }

    }

    Marker run(Marker no) {
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            no = row.move(no);
            String result = generate(rows,Position.create(NaturalNumber.createFromArrayIndex(i),no));
            System.out.println(result);
        }
        return no;
    }


    void drawLine(NaturalNumber height, NaturalNumber start) {
        if(isOverHeight(height)) {
            throw new IllegalArgumentException("사다리 최대 높이를 넘습니다.");
        }
        rows[height.toArrayIndex()].draw(start);
    }

    private boolean isOverHeight(NaturalNumber height) {
        return height.toArrayIndex() > rows.length - 1;
    }

    public static String generate(Row[] rows, Position position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            row.generateRow(position, sb, i);
        }
        return sb.toString();
    }


}
