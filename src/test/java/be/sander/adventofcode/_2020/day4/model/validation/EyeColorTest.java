package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EyeColorTest {

    @Test
    void validateSpecifics() {
        assertThat(new EyeColor("amb").validateSpecifics()).isTrue();
        assertThat(new EyeColor("blu").validateSpecifics()).isTrue();
        assertThat(new EyeColor("brn").validateSpecifics()).isTrue();
        assertThat(new EyeColor("gry").validateSpecifics()).isTrue();
        assertThat(new EyeColor("grn").validateSpecifics()).isTrue();
        assertThat(new EyeColor("hzl").validateSpecifics()).isTrue();
        assertThat(new EyeColor("oth").validateSpecifics()).isTrue();

        assertThat(new EyeColor("").validateSpecifics()).isFalse();
        assertThat(new EyeColor("blue").validateSpecifics()).isFalse();
        assertThat(new EyeColor("amb blu").validateSpecifics()).isFalse();
        assertThat(new EyeColor("gry grn").validateSpecifics()).isFalse();
        assertThat(new EyeColor("hzl oth").validateSpecifics()).isFalse();
    }
}