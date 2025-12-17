package be.sander.adventofcode._2020.day6.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnswer {
    private Integer numberOfEntries;
    private Map<String, Integer> questionAnswers;

    public GroupAnswer(List<String> answersInLines) {
        this.numberOfEntries = answersInLines.size();
        this.questionAnswers = new HashMap<>();
        mapToAnswersPerQuestion(answersInLines);
    }

    public Integer getAnswersWhereEveryoneAnsweredYes(){
        return questionAnswers.entrySet()
                .stream()
                .map(questionAnswer -> questionAnswer.getValue().equals(numberOfEntries) ? 1 : 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private void mapToAnswersPerQuestion(List<String> answersInLines) {
        answersInLines
                .stream()
                .flatMap(line -> Arrays.stream(line.split("")))
                .forEach(this::addAnswer);
    }

    private void addAnswer(String answer) {
        Integer nextValue = this.questionAnswers.getOrDefault(answer, 0) + 1;
        this.questionAnswers.put(answer, nextValue);
    }
}
