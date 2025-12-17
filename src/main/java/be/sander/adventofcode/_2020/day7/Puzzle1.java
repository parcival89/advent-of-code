package be.sander.adventofcode._2020.day7;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day7.model.*;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Puzzle1 {
    public static void main(String[] args) {
        // bijwoord kleur bags contain [nummer bijwoord kleur bag(s) (, )]
        List<String> input = FileUtil.readFile("day7/puzzle1.txt");

        List<BagRule> knownRules = input.stream()
                .map(BagRuleFactory::createBagRule)
                .peek(bagRule -> System.out.println("bag rule: " + bagRule))
                .collect(toList());

        Set<BagRule> buildUpRules = BagRuleTreeTraverser.traverseUp(knownRules, Bag.of("shiny", "gold"));

        System.out.println("Shiny gold candidates: " + buildUpRules.size());
    }
}
