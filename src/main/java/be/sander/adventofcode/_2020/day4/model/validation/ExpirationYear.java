package be.sander.adventofcode._2020.day4.model.validation;

public class ExpirationYear extends Validation<Integer>{

    public ExpirationYear(Integer value) {
        super(value);
    }

    @Override
    boolean validateSpecifics() {
        return value > 2019 && value < 2031;
    }
}
