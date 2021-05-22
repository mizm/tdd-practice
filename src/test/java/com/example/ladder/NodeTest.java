package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.ladder.Node.Direction.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    //Node Class

    @Test
    void testCreateCenter() {
        assertThat(Node.createCenterNode()).isEqualTo(Node.createCenterNode());
    }
    @Test
    void testCreateLeft() {
        Node node = Node.createLeftNode();
        assertThat(node).isEqualTo(Node.createLeftNode());
    }
    @Test
    void testCreateRight() {
        Node node = Node.createRightNode();
        assertThat(node).isEqualTo(Node.createRightNode());
    }

    @Test
    void testChangeRight() {
        Node node = Node.createCenterNode();
        node.changeRight();
        assertThat(node).isEqualTo(Node.createRightNode());
    }

    @Test
    void testChangeLeft() {
        Node node = Node.createCenterNode();
        node.changeLeft();
        assertThat(node).isEqualTo(Node.createLeftNode());
    }

    @Test
    void testMoveRight() {
        Node node = Node.createRightNode();
        Marker marker = node.move(new Marker(3));
        assertThat(marker).isEqualTo(new Marker(4));
    }
    @Test
    void testMoveLeft() {
        Node node = Node.createLeftNode();
        Marker marker = node.move(new Marker(3));
        assertThat(marker).isEqualTo(new Marker(2));
    }
    @Test
    void testMoveCenter() {
        Node node = Node.createCenterNode();
        Marker marker = node.move(new Marker(3));
        assertThat(marker).isEqualTo(new Marker(3));
    }

    @Test
    void testGetSymbol() {
        Node node1 = Node.createCenterNode();
        assertThat(0).isEqualTo(node1.getSymbol());
        Node node2 = Node.createRightNode();
        assertThat(1).isEqualTo(node2.getSymbol());
        Node node3 = Node.createLeftNode();
        assertThat(-1).isEqualTo(node3.getSymbol());
    }
}
