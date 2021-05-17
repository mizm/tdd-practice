package com.example.ladder;

// 1급 컬렉션
class Row {
    enum Direction {
        LEFT(-1),
        CENTER(0),
        RIGHT(1);

        private int no;

        Direction(int no) {
            this.no = no;
        }

        private int getNo() {
            return no;
        }
    }


    private int[] persons;

    Row(NaturalNumber noOfPerson) {
        this.persons = new int[noOfPerson.getNumber()];
    }

    void draw(NaturalNumber start) {
        int startIndex = start.toArrayIndex();
        if(startIndex >= persons.length - 1) {
            throw new IllegalArgumentException("시작점은 사람 수 보다 적어야 합니다.");
        }
        if(persons[startIndex] == -1) {
            throw new IllegalArgumentException("이미 선이 그러져있습니다.");
        }
        persons[startIndex] = Direction.RIGHT.getNo();
        persons[startIndex + 1] = Direction.LEFT.getNo();
    }


    Marker move(Marker startMarker) {
        if(startMarker.toArrayIndex() > persons.length - 1) {
            throw new IllegalArgumentException("시작점은 사람 수 보다 적어야 합니다.");
        }
        if(isNoLine(startMarker.toArrayIndex())) {
            return startMarker;
        }

        if(isRightDirection(startMarker.toArrayIndex())) {
            return startMarker.moveRight();
        }
        return startMarker.moveLeft();
    }


    private boolean isRightDirection(int no) {
        return persons[no] == Direction.RIGHT.getNo();
    }

    private boolean isNoLine(int no) {
        return persons[no] == Direction.CENTER.getNo();
    }
}
