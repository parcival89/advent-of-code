package be.sander.adventofcode._2020.day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static be.sander.adventofcode._2020.FileUtil.readFile;
import static java.util.stream.Collectors.toList;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        List<Integer> expenses = readFile("day1/puzzle2.txt")
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
        System.out.println(solve(expenses));
    }

    private static String solve(List<Integer> expenses) {
        for (Integer expense : expenses) {
            for (Integer otherExpense : expenses) {
                Integer thirdExpense = 2020 - expense - otherExpense;
                    if (expenses.contains(thirdExpense)) {
                        return String.format("%d and %d, %d, multiplied: %d", expense, otherExpense, thirdExpense,expense * otherExpense * thirdExpense);
                    }
                }
        }
        return "no luck, code better";
    }
}
