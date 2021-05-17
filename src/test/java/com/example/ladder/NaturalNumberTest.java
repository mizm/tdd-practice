package com.example.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class NaturalNumberTest {
    @Test
    void create() {
        NaturalNumber naturalNumber = new NaturalNumber(1);
        assertThat(naturalNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성할 때 0보다 크지 않으면 exception ")
    void createFail() {
        assertThrows(IllegalArgumentException.class,
                () -> new NaturalNumber(0));
    }

    @Test
    void toArrayIndex() {
        NaturalNumber naturalNumber = new NaturalNumber(3);
        assertThat(naturalNumber.toArrayIndex()).isEqualTo(2);
    }
}