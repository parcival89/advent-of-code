package be.sander.adventofcode._2020.day11.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {
    private final Tile[][] state;

    private State(Tile[][] state) {
        this.state = state;
    }

    public State(List<String> input) {
        this.state = new Tile[input.size()][input.get(0).length()];
        for (int row = 0; row < state.length; row++) {
            for (int column = 0; column < state[row].length; column++) {
                state[row][column] = Tile.of(input.get(row).charAt(column));
            }
        }
    }

    public State cycle() {
        Tile[][] newState = new Tile[state.length][state[0].length];
        for (int row = 0; row < state.length; row++) {
            for (int column = 0; column < state[row].length; column++) {
                List<Tile> adjacentTiles = getAdjacentTiles(row, column);
                newState[row][column] = state[row][column].applyRule(adjacentTiles);
            }
        }
        return new State(newState);
    }

    private List<Tile> getAdjacentTiles(int row, int column) {
        List<Tile> adjacentTiles = new ArrayList<>();
        if (row > 0) {
            if (column > 0) {
                adjacentTiles.add(state[row - 1][column - 1]);
            }
            adjacentTiles.add(state[row - 1][column]);
            if (column < state[0].length - 1) {
                adjacentTiles.add(state[row - 1][column + 1]);
            }
        }

        if (column > 0) {
            adjacentTiles.add(state[row][column - 1]);
        }
        if (column < state.length - 1) {
            adjacentTiles.add(state[row][column + 1]);
        }

        if (row < state.length - 1) {
            adjacentTiles.add(state[row + 1][column]);
            if (column > 0) {
                adjacentTiles.add(state[row + 1][column - 1]);
            }
            if (column < state[0].length - 1) {
                adjacentTiles.add(state[row + 1][column + 1]);
            }
        }

        return adjacentTiles;
    }

    public Integer countOccupied() {
        Integer occupied = 0;
        for (Tile[] tiles : state) {
            for (Tile tile : tiles) {
                if (tile == Tile.OCCUPIED) {
                    occupied++;
                }
            }
        }
        return occupied;
    }

    public boolean isSame(State other) {
        boolean isSame = true;
        for (int row = 0; row < state.length; row++) {
            for (int column = 0; column < state[row].length; column++) {
                isSame &= state[row][column] == other.state[row][column];
            }
        }
        return isSame;
    }

    public void print() {
        System.out.println("divider");
        for (Tile[] tileRow : state) {
            String collected = Arrays.stream(tileRow).map(Tile::getIdentifier).map(String::valueOf).reduce((character, character2) -> character + character2).orElse("");
            System.out.println(collected);
        }
        System.out.println("divider");
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(state);
    }

    public char[][] getState() {
        char[][] charState = new char[state.length][state[0].length];
        for (int row = 0; row < state.length; row++) {
            for (int column = 0; column < state[row].length; column++) {
                charState[row][column] = state[row][column].getIdentifier();
            }
        }
        return charState;
    }
}
