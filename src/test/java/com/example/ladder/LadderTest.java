package com.example.ladder;

import com.example.core.NaturalNumber;
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
        assertThat(ladder.run(new Marker(1))).isEqualTo(new Marker(4));
        assertThat(ladder.run(new Marker(2))).isEqualTo(new Marker(1));
        assertThat(ladder.run(new Marker(3))).isEqualTo(new Marker(2));
        assertThat(ladder.run(new Marker(4))).isEqualTo(new Marker(3));
    }

    @Test
    @DisplayName("그릴 라인은 최대치 보다 작아야 합니다.")
    void testDrawUnderMax() {
        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        assertThrows(IllegalArgumentException.class,
                () -> ladder.drawLine(new NaturalNumber(4), new NaturalNumber(2)));
    }
}
