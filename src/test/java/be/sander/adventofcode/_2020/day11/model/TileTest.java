package be.sander.adventofcode._2020.day11.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static be.sander.adventofcode._2020.day11.model.Tile.*;
import static org.assertj.core.api.Assertions.assertThat;

class TileTest {

    @Test
    void applyRule_GivenFloor_ThenStayFloor(){
        assertThat(FLOOR.applyRule(List.of(FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR))).isEqualTo(FLOOR);
        assertThat(FLOOR.applyRule(List.of(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY))).isEqualTo(FLOOR);
        assertThat(FLOOR.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED))).isEqualTo(FLOOR);
    }

    @Test
    void applyRule_GivenEmpty_AndAdjacantsAreEmpty_ThenBecomeOccupied(){
        assertThat(EMPTY.applyRule(List.of(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY))).isEqualTo(OCCUPIED);
    }

    @Test
    void applyRule_GivenEmpty_AndAdjacantsAreFloor_ThenBecomeOccupied(){
        assertThat(EMPTY.applyRule(List.of(FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR, FLOOR))).isEqualTo(OCCUPIED);
    }

    @Test
    void applyRule_GivenEmpty_AndAdjacantsAreFloorOrEmpty_ThenBecomeOccupied(){
        assertThat(EMPTY.applyRule(List.of(FLOOR, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY))).isEqualTo(OCCUPIED);
    }

    @Test
    void applyRule_GivenEmpty_AndOneOrMoreAdjacantsIsOccupied_ThenStayEmpty(){
        assertThat(EMPTY.applyRule(List.of(FLOOR, EMPTY, FLOOR, OCCUPIED, FLOOR, EMPTY, FLOOR, EMPTY))).isEqualTo(EMPTY);
        assertThat(EMPTY.applyRule(List.of(OCCUPIED, EMPTY, OCCUPIED, OCCUPIED, OCCUPIED, EMPTY, OCCUPIED, EMPTY))).isEqualTo(EMPTY);
        assertThat(EMPTY.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED))).isEqualTo(EMPTY);
    }

    @Test
    void applyRule_GivenOccupied_AndALlAdjacantsAreUnoccupied_ThenStayOccupied() {
        assertThat(OCCUPIED.applyRule(List.of(FLOOR, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY))).isEqualTo(OCCUPIED);
    }

    @Test
    void applyRule_GivenOccupied_AndLessThan4AdjacantsAreOccupied_ThenStayOccupied() {
        assertThat(OCCUPIED.applyRule(List.of(OCCUPIED, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY))).isEqualTo(OCCUPIED);
        assertThat(OCCUPIED.applyRule(List.of(FLOOR, OCCUPIED, OCCUPIED, EMPTY, FLOOR, EMPTY, FLOOR, EMPTY))).isEqualTo(OCCUPIED);
        assertThat(OCCUPIED.applyRule(List.of(FLOOR, EMPTY, FLOOR, EMPTY, OCCUPIED, OCCUPIED, OCCUPIED, EMPTY))).isEqualTo(OCCUPIED);
    }

    @Test
    void applyRule_GivenOccupied_And4OrMoreAdjacantsAreOccupied_ThenStayOccupied() {
        assertThat(OCCUPIED.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, FLOOR, EMPTY, FLOOR, EMPTY))).isEqualTo(EMPTY);
        assertThat(OCCUPIED.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, EMPTY, FLOOR, EMPTY))).isEqualTo(EMPTY);
        assertThat(OCCUPIED.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, FLOOR, EMPTY))).isEqualTo(EMPTY);
        assertThat(OCCUPIED.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, EMPTY))).isEqualTo(EMPTY);
        assertThat(OCCUPIED.applyRule(List.of(OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED))).isEqualTo(EMPTY);
    }
}