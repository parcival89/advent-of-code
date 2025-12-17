package be.sander.adventofcode._2020.day4.model;

import be.sander.adventofcode._2020.day4.model.validation.*;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class Passport {
    protected final BirthYear birthYear;
    protected final IssueYear issueYear;
    protected final ExpirationYear expirationYear;
    protected final Height height;
    protected final HairColor hairColor;
    protected final EyeColor eyeColor;
    protected final PassportId passportId;

    public Passport(Map<String, String> passportProperties) {
        this.passportId = new PassportId(passportProperties.get("pid"));
        this.eyeColor = new EyeColor(passportProperties.get("ecl"));
        this.hairColor = new HairColor(passportProperties.get("hcl"));
        this.height = new Height(passportProperties.get("hgt"));
        this.expirationYear = new ExpirationYear(nullSafeParse(passportProperties, "eyr"));
        this.issueYear = new IssueYear(nullSafeParse(passportProperties, "iyr"));
        this.birthYear = new BirthYear(nullSafeParse(passportProperties, "byr"));
    }

    public boolean isValid(){
        return passportId.validateMinimal() &&
                birthYear.validateMinimal() &&
                issueYear.validateMinimal() &&
                expirationYear.validateMinimal() &&
                height.validateMinimal() &&
                hairColor.validateMinimal() &&
                eyeColor.validateMinimal();
    }

    private Integer nullSafeParse(Map<String, String> passportProperties, String eyr) {
        return passportProperties.containsKey(eyr) ? parseInt(passportProperties.get(eyr)) : null;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "birthYear=" + birthYear +
                ", issueYear=" + issueYear +
                ", expirationYear=" + expirationYear +
                ", height='" + height + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", passportId='" + passportId + '\'' +
                '}';
    }
}
