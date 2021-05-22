package com.example.ladder;

import com.example.core.NaturalNumber;

// 1급 컬렉션
class Row {
    private Node[] nodes;

    Row(NaturalNumber noOfPerson) {
        this.nodes = new Node[noOfPerson.getNumber()];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Node.createCenterNode();
        }
    }

    void draw(NaturalNumber start) {
        int startIndex = start.toArrayIndex();
        if(isOverNoOfPerson(startIndex)) {
            throw new IllegalArgumentException("시작점은 사람 수 보다 적어야 합니다.");
        }

        if(nodes[startIndex].isLeftDirection()) {
            throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
        }
        nodes[startIndex].changeRight();
        nodes[startIndex + 1].changeLeft();

    }

    private boolean isOverNoOfPerson(int startIndex) {
        //사람 수가 5이면 선의 시작점은 4 이상일 수 없다.
        return startIndex >= nodes.length - 1;
    }

    Marker move(Marker marker) {
        if(marker.toArrayIndex() >= nodes.length) {
            throw new IllegalArgumentException("시작점은 사람 수 보다 적어야 합니다.");
        }
        return nodes[marker.toArrayIndex()].move(marker);
    }
}
