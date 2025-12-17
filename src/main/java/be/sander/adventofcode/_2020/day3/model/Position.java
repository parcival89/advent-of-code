package be.sander.adventofcode._2020.day3.model;

public class Position {
    private final Integer x;
    private final Integer y;

    public static final Position GROUND_ZERO = new Position(0,0);

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
