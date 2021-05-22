package com.example.ladder;

import com.example.core.NaturalNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class PositionTest {

    @Test
    void create() {
        Position position1 = Position.create(new NaturalNumber(3), new NaturalNumber(4));
        Position position2 = Position.create(3, 4);
        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void createFromArrayIndex() {
        Position position2 = Position.createFromArrayIndex(2,3);
        Position position1 = Position.create(new NaturalNumber(3), new NaturalNumber(4));
        assertThat(position1).isEqualTo(position2);
    }
}
