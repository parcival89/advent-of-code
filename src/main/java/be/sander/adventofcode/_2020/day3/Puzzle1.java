package be.sander.adventofcode._2020.day3;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day3.model.CharAtPosition;
import be.sander.adventofcode._2020.day3.model.MatrixTraverser;
import be.sander.adventofcode._2020.day3.model.Position;

import java.util.List;

import static be.sander.adventofcode._2020.day3.model.Position.GROUND_ZERO;

public class Puzzle1 {

    private static MatrixTraverser matrixTraverser;

    public static void main(String[] args) {
        List<String> matrix = FileUtil.readFile("day3/puzzle1.txt");
        matrixTraverser = new MatrixTraverser(matrix, new Position(3, 1));

        System.out.printf("Number of trees: %d%n", traverseUntilEndAndCountTrees(GROUND_ZERO));
    }

    public static Long traverseUntilEndAndCountTrees(Position currentPosition){
        CharAtPosition charAtNextPosition = matrixTraverser.traverse(currentPosition);
        if(charAtNextPosition == null){
            return 0L;
        }
        return isItATree(charAtNextPosition.getCharacter()) + traverseUntilEndAndCountTrees(charAtNextPosition.getPosition());
    }

    private static Long isItATree(char charAtNextPosition) {
        return charAtNextPosition == '#' ? 1L : 0L;
    }
}
