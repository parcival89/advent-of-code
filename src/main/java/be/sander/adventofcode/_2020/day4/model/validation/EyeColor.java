package be.sander.adventofcode._2020.day4.model.validation;

import java.util.List;

public class EyeColor extends Validation<String>{
    private List<String> colors = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
    public EyeColor(String value) {
        super(value);
    }

    @Override
    boolean validateSpecifics() {
        return colors.contains(value);
    }
}
