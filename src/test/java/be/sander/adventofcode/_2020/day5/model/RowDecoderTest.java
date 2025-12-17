package be.sander.adventofcode._2020.day5.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RowDecoderTest {

    @Test
    void decode() {
        RowDecoder decoder = new RowDecoder();
        assertThat(decoder.decode("FFFFFFF")).isEqualTo(0);
        assertThat(decoder.decode("BBBBBBB")).isEqualTo(127);

        assertThat(decoder.decode("BFFFBBF")).isEqualTo(70);
        assertThat(decoder.decode("FFFBBBF")).isEqualTo(14);
        assertThat(decoder.decode("BBFFBBF")).isEqualTo(102);
    }
}