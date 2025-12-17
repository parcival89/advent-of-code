package be.sander.adventofcode._2020.day1;

import java.util.List;

import static be.sander.adventofcode._2020.FileUtil.readFile;
import static java.util.stream.Collectors.toList;

public class Puzzle1 {

    public static void main(String[] args) {
        List<Integer> expenses = readFile("day1/puzzle1.txt")
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
        System.out.println(solve(expenses));
    }

    private static String solve(List<Integer> expenses) {
        for (Integer expense : expenses) {
            Integer otherExpense = 2020 - expense;
            if (expenses.contains(otherExpense)) {
                return String.format("%d and %d, multiplied: %d", expense, otherExpense, expense * otherExpense);
            }
        }
        return "no luck, code better";
    }
}
