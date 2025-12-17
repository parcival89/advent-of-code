package be.sander.adventofcode._2020.day6;

import be.sander.adventofcode._2020.day6.model.GroupAnswer;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static be.sander.adventofcode._2020.FileUtil.readFile;
import static be.sander.adventofcode._2020.day6.QuestionnaireReader.readGroupOfAnswers;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> input = readFile("day6/puzzle2.txt");
        Optional<Integer> sumOfAnswers = QuestionnaireReader.readGroupAnswers(input)
                .stream()
                .map(GroupAnswer::getAnswersWhereEveryoneAnsweredYes)
                .reduce(Integer::sum);

        System.out.println("Sum of answers of all groups: " + sumOfAnswers);
    }

}
