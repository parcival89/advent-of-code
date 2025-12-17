package be.sander.adventofcode._2020.day4.model.validation;

public class IssueYear extends Validation<Integer> {
    public IssueYear(Integer value) {
        super(value);
    }

    @Override
    boolean validateSpecifics() {
        return value > 2009 && value < 2021;
    }
}
