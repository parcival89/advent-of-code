package be.sander.adventofcode._2020.day6;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static be.sander.adventofcode._2020.FileUtil.readFile;
import static be.sander.adventofcode._2020.day6.QuestionnaireReader.readGroupOfAnswers;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> input = readFile("day6/puzzle1.txt");
        Optional<Integer> sumOfAnswers = readGroupOfAnswers(input)
                .stream()
                .map(Set::size)
                .reduce(Integer::sum);

        System.out.println("Sum of answers of all groups: " + sumOfAnswers);
    }

}
