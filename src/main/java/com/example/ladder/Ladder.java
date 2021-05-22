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

    public static String generate(Row[] rows, NaturalNumber height, NaturalNumber noOfPerson) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            Node[] nodes = row.getNodes();
            for (int j = 0; j < nodes.length; j++) {
                Node node = nodes[j];
                if(node.equals(Node.createCenterNode())) {
                    sb.append("0");
                } else if(node.equals(Node.createLeftNode())) {
                    sb.append("-1");
                } else if(node.equals(Node.createRightNode())) {
                    sb.append("1");
                }
                if(height.toArrayIndex() == i && noOfPerson.toArrayIndex() == j) {
                    sb.append("*");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    Marker run(Marker no) {
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            no = row.move(no);
            String result = generate(rows,new NaturalNumber(i+1),no);
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
}
