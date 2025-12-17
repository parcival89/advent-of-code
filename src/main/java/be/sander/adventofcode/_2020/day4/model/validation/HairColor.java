package be.sander.adventofcode._2020.day4.model.validation;

public class HairColor extends Validation<String>{
    public HairColor(String value) {
        super(value);
    }

    @Override
    boolean validateSpecifics() {
        return value.matches("#[0-9a-f]{6}");
    }
}
