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

    Row(int noOfPerson) {
        this.persons = new int[noOfPerson];
    }

    void draw(int start) {
        persons[start] = Direction.RIGHT.getNo();
        persons[start + 1] = Direction.LEFT.getNo();
    }

    int move(int no) {
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
