package be.sander.adventofcode._2020.day4.model.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IssueYearTest {

    @Test
    void validateSpecifics() {
        assertThat(new IssueYear(2009).validateSpecifics()).isFalse();
        assertThat(new IssueYear(2010).validateSpecifics()).isTrue();
        assertThat(new IssueYear(2015).validateSpecifics()).isTrue();
        assertThat(new IssueYear(2020).validateSpecifics()).isTrue();
        assertThat(new IssueYear(2021).validateSpecifics()).isFalse();
    }
}