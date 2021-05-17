package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {



    @Test
    @DisplayName("라인이 여러개인 경우")
    void testRunWhenMultiLine() {
        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        // 1 1 0 0
        // 0 1 1 0
        // 0 0 1 1
        ladder.drawLine(new NaturalNumber(1),new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(2),new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3),new NaturalNumber(3));

        // 0 -> 3
        // 1 -> 0
        // 2 -> 1
        // 3 -> 2
        assertThat(ladder.run(0)).isEqualTo(3);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(1);
        assertThat(ladder.run(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("그릴 라인은 0 이상이어야 합니다.")
    void testDrawOverOne() {
        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        assertThrows(IllegalArgumentException.class,
                () -> ladder.drawLine(new NaturalNumber(0),new NaturalNumber(2)));
    }

    @Test
    @DisplayName("그릴 라인은 최대치 보다 작아야 합니다.")
    void testDrawUnderMax() {
        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        assertThrows(IllegalArgumentException.class,
                () -> ladder.drawLine(new NaturalNumber(4), new NaturalNumber(2)));
    }
}
