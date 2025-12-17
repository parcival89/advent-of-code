package be.sander.adventofcode._2020.day5.model;

public class BoardingPassDecoder {

    private final RowDecoder rowDecoder;
    private final SeatDecoder seatDecoder;

    public BoardingPassDecoder() {
        this.rowDecoder = new RowDecoder();
        this.seatDecoder = new SeatDecoder();
    }

    public Seat decode(String boardingPass){
        Integer row = rowDecoder.decode(boardingPass.substring(0,7));
        Integer column = seatDecoder.decode(boardingPass.substring(7));
        return new Seat(row, column);
    }
}
