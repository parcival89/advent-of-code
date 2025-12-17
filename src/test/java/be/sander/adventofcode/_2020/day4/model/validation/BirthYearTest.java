package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BirthYearTest {

    @Test
    void validateSpecifics() {
        assertThat(new BirthYear(1919).validateSpecifics()).isFalse();
        assertThat(new BirthYear(1920).validateSpecifics()).isTrue();
        assertThat(new BirthYear(2000).validateSpecifics()).isTrue();
        assertThat(new BirthYear(2002).validateSpecifics()).isTrue();
        assertThat(new BirthYear(2003).validateSpecifics()).isFalse();
    }
}