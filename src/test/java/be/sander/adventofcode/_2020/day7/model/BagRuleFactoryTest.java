package be.sander.adventofcode._2020.day7.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class BagRuleFactoryTest {

    @Test
    void createBagRule() {
        String input = "shiny gold bags contain 2 dark red bags.";

        BagRule actual = BagRuleFactory.createBagRule(input);

        assertThat(actual).isEqualTo(BagRule.of(Bag.of("shiny", "gold"), 1)
                .containing(List.of(
                        BagRule.of(Bag.of("dark", "red"), 1).containing(emptyList()),
                        BagRule.of(Bag.of("dark", "red"), 1).containing(emptyList())
                )));
    }

    @Test
    void createBagRule_multipleBags() {
        String input = "shiny gold bags contain 2 dark red bags, 3 shiny violet bags.";

        BagRule actual = BagRuleFactory.createBagRule(input);

        assertThat(actual).isEqualTo(BagRule.of(Bag.of("shiny", "gold"), 1)
                .containing(List.of(
                        BagRule.of(Bag.of("dark", "red"), 1).containing(emptyList()),
                        BagRule.of(Bag.of("dark", "red"), 1).containing(emptyList()),
                        BagRule.of(Bag.of("shiny", "violet"), 1).containing(emptyList()),
                        BagRule.of(Bag.of("shiny", "violet"), 1).containing(emptyList()),
                        BagRule.of(Bag.of("shiny", "violet"), 1).containing(emptyList())
                )));
    }
}