package be.sander.adventofcode._2020.day4;

import be.sander.adventofcode._2020.day4.model.Passport;
import be.sander.adventofcode._2020.day4.model.ValidatingPassport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static be.sander.adventofcode._2020.FileUtil.readFile;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class PassportReader {

    public static List<Passport> readPassports(List<String> strings) {
        return readToMap(strings)
                .stream()
                .map(Passport::new)
                .collect(toList());
    }

    public static List<ValidatingPassport> readValidatingPassports(List<String> strings) {
        return readToMap(strings)
                .stream()
                .map(ValidatingPassport::new)
                .collect(toList());
    }

    private static List<Map<String, String>> readToMap(List<String> strings) {
        return arrangeInPassportCandidates(strings).stream()
                .map(lines -> lines.stream()
                        .flatMap(line -> stream(line.split(" ")))
                        .collect(toMap(
                                keyandValue -> keyandValue.split(":")[0],
                                keyandValue -> keyandValue.split(":")[1]
                        )))
                .collect(toList());
    }

    private static List<List<String>> arrangeInPassportCandidates(List<String> strings) {
        List<List<String>> preSorted = new ArrayList<>();
        List<String> passportCandidate = new ArrayList<>();
        for (String line : strings) {
            if (line.isBlank()) {
                preSorted.add(passportCandidate);
                passportCandidate = new ArrayList<>();
            } else {
                passportCandidate.add(line);
            }
        }
        preSorted.add(passportCandidate);
        return preSorted;
    }
}
