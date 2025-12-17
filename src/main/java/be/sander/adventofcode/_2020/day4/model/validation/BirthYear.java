package be.sander.adventofcode._2020.day4.model.validation;

public class BirthYear extends Validation<Integer> {

    public BirthYear(Integer value) {
        super(value);
    }

    @Override
    boolean validateSpecifics() {
        return value > 1919 && value < 2003;
    }
}
