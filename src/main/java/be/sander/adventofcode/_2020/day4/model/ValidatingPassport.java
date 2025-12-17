package be.sander.adventofcode._2020.day4.model;

import java.util.Map;

public class ValidatingPassport extends Passport {
    public ValidatingPassport(Map<String, String> passportProperties) {
        super(passportProperties);
    }

    @Override
    public boolean isValid() {
        return passportId.validate() &&
                birthYear.validate() &&
                issueYear.validate() &&
                expirationYear.validate() &&
                height.validate() &&
                hairColor.validate() &&
                eyeColor.validate();
    }
}
