package be.sander.adventofcode._2020.day11.model;

import java.util.Arrays;
import java.util.List;

public enum Tile {
    EMPTY('L'), OCCUPIED('#'), FLOOR('.');

    private char identifier;

    Tile(char identifier) {
        this.identifier = identifier;
    }

    public static Tile of(char identifier) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.identifier == identifier)
                .findAny()
                .orElseThrow();
    }

    public char getIdentifier() {
        return identifier;
    }

    public Tile applyRule(List<Tile> adjacentTiles) {
        if (this == EMPTY && noneOccupied(adjacentTiles)) {
            return OCCUPIED;
        } else if (this == OCCUPIED && fourOrMoreOccupied(adjacentTiles)) {
            return EMPTY;
        }
        return this;
    }

    private boolean fourOrMoreOccupied(List<Tile> adjacentTiles) {
        return adjacentTiles.stream().filter(tile -> tile == OCCUPIED).count() >= 4;
    }

    private static boolean noneOccupied(List<Tile> adjacentTiles) {
        return adjacentTiles.stream().noneMatch(tile -> tile == OCCUPIED);
    }
}
