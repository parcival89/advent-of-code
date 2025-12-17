package be.sander.adventofcode._2020.day7.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class BagRuleTreeTraverserTest {

    @Test
    void traverseDown() {
        List<String> input = List.of(
                "shiny gold bags contain 2 dark red bags.\n",
                "dark red bags contain 2 dark orange bags.\n",
                "dark orange bags contain 2 dark yellow bags.\n",
                "dark yellow bags contain 2 dark green bags.\n");
        List<BagRule> bagRules = input.stream()
                .map(BagRuleFactory::createBagRule)
                .collect(Collectors.toList());
        Bag bag = Bag.of("shiny", "gold");

        BagRule bagRule = BagRuleTreeTraverser.traverseDown(bagRules, bag);

        BagRule containing = BagRule.of(Bag.of("dark", "red"), 1)
                .containing(List.of(BagRule.of(Bag.of("dark", "orange"), 1)
                        .containing(List.of(BagRule.of(Bag.of("dark", "yellow"), 1)
                                .containing(List.of(BagRule.of(Bag.of("dark", "green"), 1)
                                                        .containing(emptyList())
                                                ))))));
        assertThat(bagRule).isEqualTo(BagRule.of(bag, 1)
                .containing(List.of(containing, containing)));
    }
}