package be.sander.adventofcode._2020.day5;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day5.model.BoardingPassDecoder;
import be.sander.adventofcode._2020.day5.model.Seat;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> boardingPassesAsStrings = FileUtil.readFile("day5/puzzle2.txt");
        BoardingPassDecoder boardingPassDecoder = new BoardingPassDecoder();

        List<Integer> orderedSeatIds = boardingPassesAsStrings.stream()
                .map(boardingPassDecoder::decode)
                .map(Seat::calculateSeatId)
                .sorted(naturalOrder())
                .collect(Collectors.toList());

        for (int i = 7; i < orderedSeatIds.size() - 8; i++) {
            if (orderedSeatIds.get(i) - orderedSeatIds.get(i - 1) != 1) {
                System.out.println("my SeatID: " + (orderedSeatIds.get(i) - 1));
            }
        }

    }
}
