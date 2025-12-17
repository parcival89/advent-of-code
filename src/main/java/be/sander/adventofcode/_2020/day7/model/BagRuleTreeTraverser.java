package be.sander.adventofcode._2020.day7.model;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class BagRuleTreeTraverser {

    public static Set<BagRule> traverseUp(List<BagRule> rules, Bag bag) {
        Set<BagRule> candidates = new HashSet<>();

        Set<Bag> previousLayer = Set.of(bag);
        int currentSize;
        do {
            currentSize = candidates.size();
            Set<BagRule> nextLayer = getLayerUp(rules, previousLayer);
            candidates.addAll(nextLayer);
            previousLayer = nextLayer.stream().map(BagRule::getBag).collect(toSet());
        } while (candidates.size() != currentSize);

        return candidates;
    }

    private static Set<BagRule> getLayerUp(List<BagRule> rules, Set<Bag> previousLayer) {
        return rules.stream()
                .filter(rule -> rule.containsAny(previousLayer))
                .collect(toSet());
    }

    public static BagRule traverseDown(List<BagRule> rules, Bag bag) {
        return rules.stream()
                .filter(rule -> rule.getBag().equals(bag))
                .map(rule -> BagRule.of(rule.getBag(), rule.getAmount())
                                    .containing(createContainingNodes(rules, rule)))
                .findAny()
                .orElse(null);
    }

    private static List<BagRule> createContainingNodes(List<BagRule> rules, BagRule bagRule) {
        List<Bag> bags = bagRule.getContainedBags().stream().map(BagRule::getBag).collect(toList());
        return rules.stream()
                .filter(rule -> bags.contains(rule.getBag()))
                .map(rule -> BagRule.of(rule.getBag(), rule.getAmount())
                .containing(createContainingNodes(rules, rule)))
                .collect(toList());
    }
}
