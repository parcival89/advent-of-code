package be.sander.adventofcode._2020.day5.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {
    @Test
    void calculateSeatId() {
        assertThat(new Seat(1,1).calculateSeatId()).isEqualTo(9);
        assertThat(new Seat(1,0).calculateSeatId()).isEqualTo(8);
        assertThat(new Seat(0,0).calculateSeatId()).isEqualTo(0);
        assertThat(new Seat(0,1).calculateSeatId()).isEqualTo(1);
    }
}
