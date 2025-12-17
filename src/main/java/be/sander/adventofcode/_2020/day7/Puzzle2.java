package be.sander.adventofcode._2020.day7;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day7.model.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day7/puzzle2.txt");

        List<BagRule> knownRules = input.stream()
                .map(BagRuleFactory::createBagRule)
                .peek(bagrule -> System.out.println("bag rule: " + bagrule))
                .collect(toList());

        Bag bag = Bag.of("shiny", "gold");

        System.out.println("Shiny gold candidates: " + calculate(knownRules, bag));
    }

    private static BagRule findBag(List<BagRule> rules, Bag bag){
        return rules.stream()
                .filter(rule -> rule.getBag().equals(bag))
                .findAny().orElse(null);
    }

    private static Integer calculate(List<BagRule> rules, Bag bag){
        BagRule bagRule = findBag(rules, bag);
        Integer calculated = bagRule.getContainedBags().stream()
                .map(BagRule::getBag)
                .map(toCalculate -> calculate(rules, toCalculate))
                .reduce(Integer::sum)
                .orElse(0);

        return 1 + calculated;
    }
}
