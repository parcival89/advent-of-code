package be.sander.adventofcode._2020.day7.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class BagRuleFactory {

    public static BagRule createBagRule(String input) {
        String[] split = input.split("contain");

        return BagRule.of(Bag.of(split[0]), 1)
                .containing(createContainingBagRules(split[1]));
    }

    private static List<BagRule> createContainingBagRules(String containingBagInfo) {
        if (containingBagInfo.equals(" no other bags.")) {
            return emptyList();
        }

        return Arrays.stream(containingBagInfo.split(", "))
                .map(String::trim)
                .flatMap(BagRuleFactory::createBags)
                .collect(toList());
    }

    private static Stream<BagRule> createBags(String input) {
        return IntStream.range(0, Integer.parseInt(input.substring(0, 1)))
                .mapToObj(number -> BagRule.of(Bag.of(input.substring(2)), 1));
    }

}
