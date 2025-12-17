package be.sander.adventofcode._2020.day10;

import be.sander.adventofcode._2020.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day10/puzzle2.txt");
        List<Long> outlets = input.stream().map(Long::parseLong).sorted(Long::compare).collect(Collectors.toList());

        System.out.println("(0), " + outlets.stream().map(String::valueOf).collect(joining(", ")) + ", (" + (outlets.get(outlets.size() - 1) + 3) + ")");

        long jolts = 0L;
        int jump1 = 0;
        int jump2 = 0;
        int jump3 = 0;
        for (long outlet : outlets) {
            if (outlet - jolts == 1) {
                jump1++;
            } else if (outlet - jolts == 2) {
                jump2++;
            } else if (outlet - jolts == 3) {
                jump3++;
            }
            jolts = outlet;
        }

        System.out.println("jump1: " + jump1);
        System.out.println("jump2: " + jump2);
        System.out.println("jump3: " + jump3);
        System.out.println("outcome: " + jump1 * (jump3 + 1));
    }
}
