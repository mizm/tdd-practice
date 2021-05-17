package com.example.ladder;

// 1급 컬렉션
public class Row {
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
    private static final int LEFT_DIRECTION = -1;
    private static final int CENTER_DIRECTION = 0;
    private static final int RIGHT_DIRECTION = 1;

    private int[] persons;

    public Row(int noOfPerson) {
        this.persons = new int[noOfPerson];
    }

    public void draw(int start) {
        persons[start] = Direction.RIGHT.getNo();
        persons[start + 1] = Direction.LEFT.getNo();
    }

    public int move(int no) {
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
