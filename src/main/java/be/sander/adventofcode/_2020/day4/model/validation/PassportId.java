package be.sander.adventofcode._2020.day4.model.validation;

public class PassportId extends Validation<String> {
    public PassportId(String value) {
        super(value);
    }

    @Override
    boolean validateSpecifics() {
        return value.matches("[0-9]{9}");
    }
}
