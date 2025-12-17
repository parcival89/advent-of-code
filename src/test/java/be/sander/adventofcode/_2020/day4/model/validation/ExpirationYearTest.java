package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpirationYearTest {

    @Test
    void validateSpecifics() {
        assertThat(new ExpirationYear(2019).validateSpecifics()).isFalse();
        assertThat(new ExpirationYear(2020).validateSpecifics()).isTrue();
        assertThat(new ExpirationYear(2025).validateSpecifics()).isTrue();
        assertThat(new ExpirationYear(2030).validateSpecifics()).isTrue();
        assertThat(new ExpirationYear(2031).validateSpecifics()).isFalse();
    }
}