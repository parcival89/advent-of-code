package be.sander.adventofcode._2020.day8.model;

import java.util.Arrays;

public enum Action {
    ACC("acc"), JMP("jmp"), NOP("nop");

    private final String identifier;

    Action(String identifier) {
        this.identifier = identifier;
    }

    public static Action of(String identifier) {
        return Arrays.stream(Action.values())
                .filter(action -> action.identifier.equals(identifier))
                .findAny()
                .orElseThrow();
    }
}
