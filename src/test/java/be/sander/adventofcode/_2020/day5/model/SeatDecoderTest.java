package be.sander.adventofcode._2020.day5.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatDecoderTest {
    @Test
    void decoder() {
        SeatDecoder decoder = new SeatDecoder();
        assertThat(decoder.decode("LLL")).isEqualTo(0);
        assertThat(decoder.decode("RRR")).isEqualTo(7);

        assertThat(decoder.decode("RLL")).isEqualTo(4);
    }
}
