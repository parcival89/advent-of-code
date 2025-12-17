package be.sander.adventofcode._2020.day4.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PassportTest {
    @Test
    void isCompliant_valid() {
        Map<String, String> given = Map.of("eyr", "2025",
                "iyr", "2011",
                "byr", "1980",
                "hcl", "#fffffd",
                "cid", "129",
                "pid", "420023864",
                "hgt", "150cm",
                "ecl", "brn");
        assertThat(new Passport(given).isValid()).isTrue();
    }

    @Test
    void isCompliant_invalid() {
        Map<String, String> given = Map.of("eyr", "2025",
                "iyr", "2011",
                "byr", "1980",
                "cid", "129",
                "pid", "420023864",
                "hgt", "150cm",
                "ecl", "brn");
        assertThat(new Passport(given).isValid()).isFalse();
    }

    @Test
    void isCompliant_valid_cidIsOptional() {
        Map<String, String> given = Map.of("eyr", "2025",
                "iyr", "2011",
                "byr", "1980",
                "hcl", "#fffffd",
                "pid", "420023864",
                "hgt", "150cm",
                "ecl", "brn");
        assertThat(new Passport(given).isValid()).isTrue();
    }
}