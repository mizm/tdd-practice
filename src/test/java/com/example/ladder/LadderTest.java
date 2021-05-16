package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {



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
