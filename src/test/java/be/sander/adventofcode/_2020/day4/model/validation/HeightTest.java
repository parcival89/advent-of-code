package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeightTest {

    @Test
    void validateSpecifics() {
        assertThat(new Height("149cm").validateSpecifics()).isFalse();
        assertThat(new Height("150cm").validateSpecifics()).isTrue();
        assertThat(new Height("155cm").validateSpecifics()).isTrue();
        assertThat(new Height("193cm").validateSpecifics()).isTrue();
        assertThat(new Height("194cm").validateSpecifics()).isFalse();

        assertThat(new Height("58in").validateSpecifics()).isFalse();
        assertThat(new Height("59in").validateSpecifics()).isTrue();
        assertThat(new Height("66in").validateSpecifics()).isTrue();
        assertThat(new Height("76in").validateSpecifics()).isTrue();
        assertThat(new Height("77in").validateSpecifics()).isFalse();
    }
}