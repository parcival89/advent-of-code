package be.sander.adventofcode._2020.day3.model;

import java.util.function.Function;

public class TraverseVector {
    private final Function<Integer, Integer> moveX;
    private final Function<Integer, Integer> moveY;

    public TraverseVector(Function<Integer, Integer> moveX, Function<Integer, Integer> moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public Position traverse(Position from){
        try {
            return new Position(moveX.apply(from.getX()), moveY.apply(from.getY()));
        }catch(RuntimeException e){
            return null;
        }
    }
}
