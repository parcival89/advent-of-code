package be.sander.adventofcode._2020.day4;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day4.model.ValidatingPassport;

import java.util.List;

import static be.sander.adventofcode._2020.day4.PassportReader.*;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> strings = FileUtil.readFile("day4/puzzle2.txt");
        System.out.println("valid passports: " + readValidatingPassports(strings)
                .stream()
                .map(passport -> (ValidatingPassport)passport)
                .peek(passport ->
                        System.out.println("Passport: " + passport + ", isCompliant? " + passport.isValid()))
                .filter(ValidatingPassport::isValid)
                .count());
    }
}
