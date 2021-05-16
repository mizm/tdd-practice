package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("라인이 없는 경우")
    void testRunWhenNoLine() {
        Ladder ladder = new Ladder(1,3);
        int target = ladder.run(0);
        assertThat(target).isEqualTo(0);
        target = ladder.run(2);
        assertThat(target).isEqualTo(2);
    }

    @Test
    @DisplayName("라인이 하나인 경우")
    void testRunWhenLeftLine() {
        // 1 1 0
        Ladder ladder = new Ladder(1,3);
        ladder.drawLine(0,0);

        int target = ladder.run(1);
        assertThat(target).isEqualTo(0);

        target = ladder.run(0);
        assertThat(target).isEqualTo(1);
    }
    @Test
    @DisplayName("라인이 하나인 경우")
    void testRunWhenRightLine() {
        // 0 1 1
        Ladder ladder = new Ladder(1,3);
        ladder.drawLine(0,1);

        int target = ladder.run(2);
        assertThat(target).isEqualTo(1);

        target = ladder.run(1);
        assertThat(target).isEqualTo(2);

        target = ladder.run(0);
        assertThat(target).isEqualTo(0);
    }

    @Test
    @DisplayName("라인이 여러개인 경우")
    void testRunWhenMultiLine() {
        Ladder ladder = new Ladder(3, 4);
        // 1 1 0 0
        // 0 1 1 0
        // 0 0 1 1
        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,2);

        // 0 -> 3
        // 1 -> 0
        // 2 -> 1
        // 3 -> 2
        assertThat(ladder.run(0)).isEqualTo(3);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(1);
        assertThat(ladder.run(3)).isEqualTo(2);
    }
}
