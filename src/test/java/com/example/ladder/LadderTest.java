package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("라인이 없는 경우")
    void testRunWhenNoLine() {
        Ladder ladder = new Ladder(2);
        int no = 1;
        int target = ladder.run(no);
        assertThat(target).isEqualTo(no);

        no = 2;
        target = ladder.run(no);
        assertThat(target).isEqualTo(no);
    }

    @Test
    @DisplayName("2개가 있을때 라인이 한개인 경우")
    void testRunWhenTwoByOneOneLine() {
        Ladder ladder = new Ladder(2);
        ladder.drawLine(0);
        int no = 1;
        int target = ladder.run(no);
        assertThat(target).isEqualTo(2);
        no = 2;
        target = ladder.run(no);
        assertThat(target).isEqualTo(1);
    }

    @Test
    @DisplayName("3개가 있을때 라인이 한개인 경우")
    void testRunWhenThreeByOneOneLine() {
        // 1 1 0
        Ladder ladder = new Ladder(3);
        ladder.drawLine(0);
        int no = 1;
        int target = ladder.run(no);
        assertThat(target).isEqualTo(2);
        no = 2;
        target = ladder.run(no);
        assertThat(target).isEqualTo(1);

        no = 3;
        target = ladder.run(no);
        assertThat(target).isEqualTo(3);
    }

    @Test
    @DisplayName("3개가 있을때 라인이 한개인 경우")
    void testRunWhenThreeByOneOneLine2() {
        // 0 1 1
        Ladder ladder = new Ladder(3);
        ladder.drawLine(1);
        int no = 1;
        int target = ladder.run(no);
        assertThat(target).isEqualTo(1);

        no = 2;
        target = ladder.run(no);
        assertThat(target).isEqualTo(3);

        no = 3;
        target = ladder.run(no);
        assertThat(target).isEqualTo(2);
    }
}
