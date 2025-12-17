package be.sander.adventofcode._2020.day11;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day11.model.State;

import java.util.List;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day11/puzzle1.txt");

        State state = new State(input);
        State previousState;
        State newState = state;
        do {
            previousState = newState;
            newState = previousState.cycle();
            newState.print();
        } while (!newState.isSame(previousState));

        State extraState = newState.cycle();
        extraState.print();
        System.out.println("Stabilizing at : " + newState.countOccupied());
    }
}
