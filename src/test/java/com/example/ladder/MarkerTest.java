package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MarkerTest {

    @Test
    void moveRight() {
        Marker marker = new Marker(3);
        assertThat(new Marker(4)).isEqualTo(marker.moveRight());
    }
    @Test
    void moveLeft() {
        Marker marker = new Marker(3);
        assertThat(new Marker(2)).isEqualTo(marker.moveLeft());
    }

}