package be.sander.adventofcode._2020.day8;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day8.model.Command;

import java.util.ArrayList;
import java.util.List;

import static be.sander.adventofcode._2020.day8.model.Action.*;
import static java.util.stream.Collectors.joining;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day8/puzzle1.txt");

        Integer acc = 0;
        List<Integer> previousCommands = new ArrayList<>();
        for (int i = 0; i < input.size(); ) {
            Command command = new Command(input.get(i));
            System.out.println(command);
            String collect = previousCommands.stream().map(number -> number + "").collect(joining(","));
            System.out.println("previous commands: " + collect);

            if (command.getAction() == ACC) {
                acc += command.getModifier();
                i++;
            } else if (command.getAction() == JMP) {
                i += command.getModifier();
            } else if (command.getAction() == NOP) {
                i++;
            }

            if (!previousCommands.contains(i)) {
                previousCommands.add(i);
            } else
                throw new IllegalArgumentException("inifinite loop detected! Last acc value: " + acc);
        }
    }
}
