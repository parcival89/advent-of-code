package be.sander.adventofcode._2020.day2.model;

public class PolicyPuzzle2 implements Policy {
    private final Character wantedCharacter;
    private final Integer position1;
    private final Integer position2;

    public PolicyPuzzle2(String policy) {
        String[] split = policy.split(" ");
        this.wantedCharacter = split[1].trim().charAt(0);
        String[] splitForPositions = split[0].split("-");
        this.position1 = Integer.parseInt(splitForPositions[0].trim());
        this.position2 = Integer.parseInt(splitForPositions[1].trim());
    }

    public boolean applies(String password) {
        return !(password.charAt(position1 - 1) == wantedCharacter && password.charAt(position2 - 1) == wantedCharacter)
                && !(password.charAt(position1 - 1) != wantedCharacter && password.charAt(position2 - 1) != wantedCharacter);
    }
}