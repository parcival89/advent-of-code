package be.sander.adventofcode._2020.day8.model;

import be.sander.adventofcode._2020.ValueObject;

import static be.sander.adventofcode._2020.day8.model.Action.JMP;
import static be.sander.adventofcode._2020.day8.model.Action.NOP;

public class Command extends ValueObject {
    private Action action;
    private Integer modifier;

    public Command(String s) {
        String[] split = s.split(" ");
        this.action= Action.of(split[0]);
        this.modifier = Integer.parseInt(split[1]);
    }

    public Action getAction() {
        return action;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void flip() {
        if(action == NOP){
            action = JMP;
        } else if (action == JMP){
            action = NOP;
        }
    }
}
