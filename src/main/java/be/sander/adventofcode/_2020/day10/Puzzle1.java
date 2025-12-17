package be.sander.adventofcode._2020.day10;

import be.sander.adventofcode._2020.FileUtil;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class Puzzle1 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day10/puzzle1.txt");
        List<Long> outlets = input.stream().map(Long::parseLong).sorted(Long::compare).collect(Collectors.toList());

        long jolts = 0L;
        int jump1 = 0;
        int jump3 = 0;
        for(long outlet: outlets){
            if(outlet - jolts == 1){
                jump1++;
            }else if(outlet - jolts == 3)
                jump3++;
            System.out.println("jolts: " + jolts + ", outlet: " + outlet + ", diff: " + (outlet - jolts));
            jolts = outlet;
        }

        System.out.println("jump1: " + jump1);
        System.out.println("jump3: " + jump3);
        System.out.println("outcome: " + jump1 * (jump3 +1));
    }
}
