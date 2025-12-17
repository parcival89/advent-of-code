package be.sander.adventofcode._2020.day3.model;

import java.util.List;
import java.util.function.Function;

public class MatrixTraverser {
    private final TraverseVector traverseVector;
    private final List<String> matrix;

    public MatrixTraverser(List<String> matrix, Position traverseVector) {
        this.traverseVector = new TraverseVector(
                createXTraverser(traverseVector, matrix.get(0).length()),
                createYTraverser(traverseVector.getY(), matrix.size()));
        this.matrix = matrix;
    }

    private Function<Integer, Integer> createYTraverser(Integer y, int yBoundary) {
        return in -> {
            if ((in + y) < yBoundary) {
                return in + y;
            } else throw new RuntimeException("End of file reached");
        };
    }

    private Function<Integer, Integer> createXTraverser(Position traverseVector, Integer xBoundary) {
        return in -> (in + traverseVector.getX()) % xBoundary;
    }

    public CharAtPosition traverse(Position currentPosition) {
        Position nextPosition = traverseVector.traverse(currentPosition);
        if(nextPosition == null){
            return null;
        }
        String row = matrix.get(nextPosition.getY());
        Integer column = nextPosition.getX();
        char charAtNextPosition = row.charAt(column);
        return new CharAtPosition(charAtNextPosition, nextPosition);
    }
}
