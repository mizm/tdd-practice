package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("라인이 없는 경우")
    void testRunWhenNoLine() {
        Ladder ladder = new Ladder(3);
        int target = ladder.run(0);
        assertThat(target).isEqualTo(0);
        target = ladder.run(2);
        assertThat(target).isEqualTo(2);
    }

    @Test
    @DisplayName("라인이 하나인 경우")
    void testRunWhenLeftLine() {
        // 1 1 0
        Ladder ladder = new Ladder(3);
        ladder.drawLine(0);

        int target = ladder.run(1);
        assertThat(target).isEqualTo(0);

        target = ladder.run(0);
        assertThat(target).isEqualTo(1);
    }
    @Test
    @DisplayName("라인이 하나인 경우")
    void testRunWhenRightLine() {
        // 0 1 1
        Ladder ladder = new Ladder(3);
        ladder.drawLine(1);

        int target = ladder.run(2);
        assertThat(target).isEqualTo(1);

        target = ladder.run(1);
        assertThat(target).isEqualTo(2);

        target = ladder.run(0);
        assertThat(target).isEqualTo(0);
    }

}
