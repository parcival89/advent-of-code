package be.sander.adventofcode._2020.day4;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day4.model.Passport;

import java.util.List;

import static be.sander.adventofcode._2020.day4.PassportReader.readPassports;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> strings = FileUtil.readFile("day4/puzzle1.txt");
        System.out.println("valid passports: " + readPassports(strings)
                .stream().peek(passport ->
                        System.out.println("Passport: " + passport + ", isCompliant? " + passport.isValid()))
                .filter(Passport::isValid)
                .count());
    }
}
