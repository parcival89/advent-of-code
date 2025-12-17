package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportIdTest {

    @Test
    void validateSpecifics() {
        assertThat(new PassportId("123456789").validateSpecifics()).isTrue();
        assertThat(new PassportId("012345678").validateSpecifics()).isTrue();
        assertThat(new PassportId("001234567").validateSpecifics()).isTrue();
        assertThat(new PassportId("000123456").validateSpecifics()).isTrue();
        assertThat(new PassportId("000012345").validateSpecifics()).isTrue();
        assertThat(new PassportId("000001234").validateSpecifics()).isTrue();
        assertThat(new PassportId("000000123").validateSpecifics()).isTrue();
        assertThat(new PassportId("000000012").validateSpecifics()).isTrue();
        assertThat(new PassportId("000000001").validateSpecifics()).isTrue();
        assertThat(new PassportId("000000000").validateSpecifics()).isTrue();

        assertThat(new PassportId("").validateSpecifics()).isFalse();
        assertThat(new PassportId("00000000a").validateSpecifics()).isFalse();
        assertThat(new PassportId("0123456789").validateSpecifics()).isFalse();
    }
}