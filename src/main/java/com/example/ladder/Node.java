package com.example.ladder;

import java.util.Objects;

import static com.example.ladder.Node.Direction.*;

public class Node {

    public Marker move(Marker marker) {
        if(this.direction == RIGHT) {
            return marker.moveRight();
        }

        if(this.direction == LEFT) {
            return marker.moveLeft();
        }
        return marker;
    }

    enum Direction {
        LEFT,CENTER,RIGHT;
    }

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    void changeRight() {
        this.direction = RIGHT;
    }
    void changeLeft() {
        this.direction = LEFT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return direction == node.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    static Node createCenterNode() {
        return new Node(CENTER);
    }
    static Node createRightNode() {
        return new Node(RIGHT);
    }
    static Node createLeftNode() {
        return new Node(LEFT);
    }
}
