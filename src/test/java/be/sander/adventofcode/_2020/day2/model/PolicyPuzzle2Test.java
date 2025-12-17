package be.sander.adventofcode._2020.day2.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PolicyPuzzle2Test {

    @Test
    void applies() {
        PolicyPuzzle2 policy = new PolicyPuzzle2("1-3 b");
        assertThat(policy.applies("baby")).isFalse();
        assertThat(policy.applies("lady")).isFalse();
        assertThat(policy.applies("laby")).isTrue();
        assertThat(policy.applies("bady")).isTrue();
    }
}