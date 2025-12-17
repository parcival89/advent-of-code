package be.sander.adventofcode._2020.day2.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @Test
    void isInRange() {
        Range range = new Range("1-3");
        assertThat(range.isInRange(0L)).isFalse();
        assertThat(range.isInRange(1L)).isTrue();
        assertThat(range.isInRange(2L)).isTrue();
        assertThat(range.isInRange(3L)).isTrue();
        assertThat(range.isInRange(4L)).isFalse();
    }
}