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

    int move(int no) {
        if(no < 0) {
            throw new IllegalArgumentException("0 이상이어야 합니다.");
        }
        if(no > persons.length - 1) {
            throw new IllegalArgumentException("시작점이 너무 큽니다.");
        }
        if(isNoLine(no)) {
            return no;
        }

        if(isRightDirection(no)) {
            return no + Direction.RIGHT.getNo();
        }
        return no + Direction.LEFT.getNo();
    }

    private boolean isRightDirection(int no) {
        return persons[no] == Direction.RIGHT.getNo();
    }

    private boolean isNoLine(int no) {
        return persons[no] == Direction.CENTER.getNo();
    }
}
