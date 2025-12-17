package be.sander.adventofcode._2020.day5.model;

public class Seat {
    private Integer row;
    private Integer column;

    public Seat(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer calculateSeatId() {
        return row*8 + column;
    }
}
