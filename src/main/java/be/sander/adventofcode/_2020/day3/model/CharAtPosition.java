package be.sander.adventofcode._2020.day3.model;

public class CharAtPosition {
    private final char character;
    private final Position position;

    public CharAtPosition(char character, Position position) {
        this.character = character;
        this.position = position;
    }

    public char getCharacter() {
        return character;
    }

    public Position getPosition() {
        return position;
    }
}
