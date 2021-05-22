package com.example.ladder;

import com.example.core.NaturalNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    @DisplayName("라인이 없는 경우")
    void testMoveWhenNoLine() {
        Row row = new Row(new NaturalNumber(3));
        NaturalNumber target = row.move(new Marker(1));
        assertThat(target.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("라인이 하나인 경우")
    void testMoveWhenLeftLine() {
        // 0 1 1
        Row row = new Row(new NaturalNumber(3));
        row.draw(new NaturalNumber(1));

        NaturalNumber target = row.move(new Marker(2));
        assertThat(target.getNumber()).isEqualTo(1);

        // 0 1 1
        row = new Row(new NaturalNumber(3));
        row.draw(new NaturalNumber(2));

        target = row.move(new Marker(3));
        assertThat(target.getNumber()).isEqualTo(2);

    }

    @Test
    @DisplayName("선을 그릴 때는 시작점은 사람수보다 작아야 한다")
    void drawOverFailTest() {
        Row row = new Row(new NaturalNumber(3));
        assertThrows(IllegalArgumentException.class,
                () ->  row.draw(new NaturalNumber(3))
        );
    }
    @Test
    @DisplayName("선을 그릴 때는 이미 그려져 있으면 안된다.")
    void drawDuplicateFailTest() {
        Row row = new Row(new NaturalNumber(3));
        row.draw(new NaturalNumber(1));
        assertThrows(IllegalArgumentException.class,
                () ->  row.draw(new NaturalNumber(2))
        );
    }

    @Test
    @DisplayName("움직일때 사람수 보다 큰 값이 시작점으로 주어져서는 안된다.")
    void moveFailTest2() {
        Row row = new Row(new NaturalNumber(3));
        assertThrows(IllegalArgumentException.class,
                () ->  row.move(new Marker(4))
        );
    }


}