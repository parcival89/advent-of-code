package be.sander.adventofcode._2020.day6;

import be.sander.adventofcode._2020.day6.model.GroupAnswer;

import java.util.*;

public class QuestionnaireReader {

    public static List<Set<String>> readGroupOfAnswers(List<String> strings) {
        List<Set<String>> preSorted = new ArrayList<>();
        Set<String> groupAnswers = new HashSet<>();
        for (String line : strings) {
            if (line.isBlank()) {
                preSorted.add(groupAnswers);
                groupAnswers = new HashSet<>();
            } else {
                groupAnswers.addAll(Arrays.asList(line.split("").clone()));
            }
        }
        preSorted.add(groupAnswers);
        return preSorted;
    }
    public static List<GroupAnswer> readGroupAnswers(List<String> strings) {
        List<GroupAnswer> preSorted = new ArrayList<>();
        List<String> groupAnswerCandidate = new ArrayList<>();
        for (String line : strings) {
            if (line.isBlank()) {
                preSorted.add(new GroupAnswer(groupAnswerCandidate));
                groupAnswerCandidate = new ArrayList<>();
            } else {
                groupAnswerCandidate.add(line);
            }
        }
        preSorted.add(new GroupAnswer(groupAnswerCandidate));
        return preSorted;
    }
}
