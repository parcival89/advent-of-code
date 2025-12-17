package be.sander.adventofcode._2020.day2.model;

public class PolicyPuzzle1 implements Policy {
    private final Character wantedCharacter;
    private final Range wantedRange;

    public PolicyPuzzle1(String policy) {
        String[] split = policy.split(" ");
        this.wantedRange = new Range(split[0].trim());
        this.wantedCharacter = split[1].trim().charAt(0);
    }

    public boolean applies(String password){
        long wantedCharOccurences = password.chars().filter(character -> wantedCharacter == character).count();
        return wantedRange.isInRange(wantedCharOccurences);
    }
}