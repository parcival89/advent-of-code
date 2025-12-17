package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HairColorTest {

    @Test
    void validateSpecifics() {
        assertThat(new HairColor("#123789").validateSpecifics()).isTrue();
        assertThat(new HairColor("#abcdef").validateSpecifics()).isTrue();
        assertThat(new HairColor("#abc123").validateSpecifics()).isTrue();

        assertThat(new HairColor("123456").validateSpecifics()).isFalse();
        assertThat(new HairColor("1234567").validateSpecifics()).isFalse();
        assertThat(new HairColor("").validateSpecifics()).isFalse();
        assertThat(new HairColor("#").validateSpecifics()).isFalse();
        assertThat(new HairColor("#1").validateSpecifics()).isFalse();
        assertThat(new HairColor("#12").validateSpecifics()).isFalse();
        assertThat(new HairColor("#123").validateSpecifics()).isFalse();
        assertThat(new HairColor("#1234").validateSpecifics()).isFalse();
        assertThat(new HairColor("#12345").validateSpecifics()).isFalse();
        assertThat(new HairColor("#1234567").validateSpecifics()).isFalse();
    }
}