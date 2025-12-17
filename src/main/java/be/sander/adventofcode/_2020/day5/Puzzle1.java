package be.sander.adventofcode._2020.day5;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day5.model.BoardingPassDecoder;
import be.sander.adventofcode._2020.day5.model.Seat;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.naturalOrder;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> boardingPassesAsStrings = FileUtil.readFile("day5/puzzle1.txt");
        BoardingPassDecoder boardingPassDecoder = new BoardingPassDecoder();

        Optional<Integer> highestSeatId = boardingPassesAsStrings.stream()
                .map(boardingPassDecoder::decode)
                .map(Seat::calculateSeatId)
                .max(naturalOrder());

        System.out.println("Highest SeatID: " + highestSeatId);
    }
}
