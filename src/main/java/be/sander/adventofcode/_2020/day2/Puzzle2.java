package be.sander.adventofcode._2020.day2;

import be.sander.adventofcode._2020.day2.model.PasswordWithPolicy;
import be.sander.adventofcode._2020.day2.model.PolicyPuzzle2;

import static be.sander.adventofcode._2020.FileUtil.readFile;

public class Puzzle2 {

    public static void main(String[] args) {
        long compliantPasswords = readFile("day2/puzzle2.txt")
                .stream()
                .map(line -> line.split(":"))
                .map(splitLine -> new PasswordWithPolicy(new PolicyPuzzle2(splitLine[0].trim()), splitLine[1].trim()))
                .filter(PasswordWithPolicy::isCompliant)
                .count();
        System.out.println("compliant passwords: " + compliantPasswords);
    }
}
