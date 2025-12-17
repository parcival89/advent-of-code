package be.sander.adventofcode._2020.day9;

import be.sander.adventofcode._2020.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day9/puzzle1.txt");

        Integer preambleSize = 25;
        List<Long> mutatingState = new ArrayList<>();
        boolean isAMatch = false;
        for (String line : input) {
            Long number = Long.parseLong(line);
            if (mutatingState.size() > preambleSize) {
                Boolean matched = match(preambleSize, mutatingState, number);
                if (!matched) {
                    System.out.println(number + " is not a valid number!");
                }
                isAMatch |= matched;
            }
            mutatingState.add(number);
        }

        System.out.println("all numbers match? " + isAMatch);
    }

    private static Boolean match(Integer preambleSize, List<Long> mutatingState, Long number) {
        List<Long> matchers = mutatingState.subList(mutatingState.size() - preambleSize, mutatingState.size());
        Boolean matched = matchers.stream()
                .map(matcher -> matchers.stream()
                        .filter(otherNumber -> !matcher.equals(otherNumber))
                        .map(otherNumber -> otherNumber + matcher == number)
                        .reduce(Boolean::logicalOr)
                        .orElse(false))
                .reduce(Boolean::logicalOr)
                .orElse(false);
        return matched;
    }
}
