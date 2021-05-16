package com.example.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    @DisplayName("라인이 없는 경우")
    void testMoveWhenNoLine() {
        Row row = new Row(3);
        int target = row.move(0);
        assertThat(target).isEqualTo(0);
        target = row.move(2);
        assertThat(target).isEqualTo(2);
    }

    @Test
    @DisplayName("라인이 하나인 경우")
    void testMoveWhenLeftLine() {
        // 0 1 1
        Row row = new Row(3);
        row.draw(0);

        int target = row.move(1);
        assertThat(target).isEqualTo(0);

        target = row.move(0);
        assertThat(target).isEqualTo(1);

        // 0 1 1
        row = new Row(3);
        row.draw(1);

        target = row.move(2);
        assertThat(target).isEqualTo(1);

        target = row.move(1);
        assertThat(target).isEqualTo(2);

        target = row.move(0);
        assertThat(target).isEqualTo(0);
    }


}