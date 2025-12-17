package be.sander.adventofcode._2020.day7.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class BagRuleTest {

    @Test
    void calculate() {
        BagRule bagRule = BagRule.of(Bag.of("shiny", "gold"), 1);

        assertThat(bagRule.calculate()).isZero();
    }

    @Test
    void calculate_GivenBagWith1Bag_CalculatesTo1() {
        BagRule bagRule = BagRule.of(Bag.of("shiny", "gold"), 1)
                .containing(List.of(
                        BagRule.of(Bag.of("dark", "violet"), 1)
                                .containing(emptyList())
                ));

        assertThat(bagRule.calculate()).isEqualTo(1*1);
    }

    @Test
    void calculate_GivenBagWith2Bags_CalculatesTo2() {
        BagRule bagRule = BagRule.of(Bag.of("shiny", "gold"), 1)
                .containing(List.of(
                        BagRule.of(Bag.of("dark", "violet"), 2)
                                .containing(emptyList())
                ));

        assertThat(bagRule.calculate()).isEqualTo(1*2);
    }

    @Test
    void calculate_Given1BagWith2BagWith2Bag_CalculatesTo4() {
        BagRule bagRule = BagRule.of(Bag.of("shiny", "gold"), 1)
                .containing(List.of(
                        BagRule.of(Bag.of("dark", "violet"), 2)
                                .containing(List.of(
                                        BagRule.of(Bag.of("dark", "red"), 2)
                                                .containing(emptyList())
                                ))));

        assertThat(bagRule.calculate()).isEqualTo(1*3 + 1*3);
    }
}