package be.sander.adventofcode._2020.day3;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day3.model.CharAtPosition;
import be.sander.adventofcode._2020.day3.model.MatrixTraverser;
import be.sander.adventofcode._2020.day3.model.Position;

import java.util.List;

import static be.sander.adventofcode._2020.day3.model.Position.GROUND_ZERO;

public class Puzzle2 {

    public static void main(String[] args) {
        List<String> matrix = FileUtil.readFile("day3/puzzle2.txt");
        MatrixTraverser matrixTraverser1 = new MatrixTraverser(matrix, new Position(1, 1));
        MatrixTraverser matrixTraverser2 = new MatrixTraverser(matrix, new Position(3, 1));
        MatrixTraverser matrixTraverser3 = new MatrixTraverser(matrix, new Position(5, 1));
        MatrixTraverser matrixTraverser4 = new MatrixTraverser(matrix, new Position(7, 1));
        MatrixTraverser matrixTraverser5 = new MatrixTraverser(matrix, new Position(1, 2));

        System.out.printf("Number of trees: %d%n",
                traverseUntilEndAndCountTrees(matrixTraverser1, GROUND_ZERO) *
                        traverseUntilEndAndCountTrees(matrixTraverser2, GROUND_ZERO) *
                        traverseUntilEndAndCountTrees(matrixTraverser3, GROUND_ZERO) *
                        traverseUntilEndAndCountTrees(matrixTraverser4, GROUND_ZERO) *
                        traverseUntilEndAndCountTrees(matrixTraverser5, GROUND_ZERO)
        );
    }

    public static Long traverseUntilEndAndCountTrees(MatrixTraverser traverser, Position currentPosition) {
        CharAtPosition charAtNextPosition = traverser.traverse(currentPosition);
        if (charAtNextPosition == null) {
            return 0L;
        }
        return isItATree(charAtNextPosition.getCharacter()) + traverseUntilEndAndCountTrees(traverser, charAtNextPosition.getPosition());
    }

    private static Long isItATree(char charAtNextPosition) {
        return charAtNextPosition == '#' ? 1L : 0L;
    }
}
