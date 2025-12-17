package be.sander.adventofcode._2020.day8;

import be.sander.adventofcode._2020.FileUtil;
import be.sander.adventofcode._2020.day8.model.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.sander.adventofcode._2020.day8.model.Action.*;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day8/puzzle2.txt");
        Map<Integer, Command> jmpsAndNops = filterJmpsAndNops(input);

        Integer succeededBootAcc = jmpsAndNops.entrySet()
                .stream()
                .map(entry -> tryToBoot(input, entry))
                .filter(acc -> acc != -1)
                .findAny()
                .orElse(-1);

        System.out.println("acc: " + succeededBootAcc);
    }

    private static Integer tryToBoot(List<String> input, Map.Entry<Integer, Command> entry) {
        try {
            Integer acc = 0;
            List<Integer> previousCommands = new ArrayList<>();

            for (int i = 0; i < input.size(); ) {
                Command command = new Command(input.get(i));

                if (i == entry.getKey()) {
                    command.flip();
                }

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
                } else throw new IllegalArgumentException("inifinite loop detected! Last acc value: " + acc);
            }
            System.out.println("boot succeeded! acc: " + acc);
            return acc;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private static Map<Integer, Command> filterJmpsAndNops(List<String> input) {
        Map<Integer, Command> jmpsAndNops = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            Command command = new Command(input.get(i));

            if (command.getAction() == JMP || command.getAction() == NOP) {
                jmpsAndNops.put(i, command);
            }
        }

        return jmpsAndNops;
    }
}
