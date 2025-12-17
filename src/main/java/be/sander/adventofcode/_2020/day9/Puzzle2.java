package be.sander.adventofcode._2020.day9;

import be.sander.adventofcode._2020.FileUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Puzzle2 {
    public static void main(String[] args) {
        List<String> input = FileUtil.readFile("day9/puzzle2.txt");
        List<Long> numbers = input.stream().map(Long::parseLong).collect(toList());

        Long toMatch = 675280050L;
        List<Long> matchers = numbers.subList(0, numbers.indexOf(toMatch));
        Collections.reverse(matchers);

        int preambleDefaultSize = 2;
        Integer preambleSize = preambleDefaultSize;
        Integer startPoint = 0;
        boolean isAMatch = false;
        while(!isAMatch){
            // waarde ophalen uit kandidatenlijst
            // optellen
            // als som < te behalen getal -> set vergroten
            // als som > te behalen getal -> index verzetten & set grootte resetten
            List<Long> candidates = matchers.subList(startPoint, startPoint + preambleSize);
            Long sumOfCandidates = candidates.stream().reduce(Long::sum).orElse(0L);
            if(sumOfCandidates < toMatch){
                preambleSize++;
            } else if(sumOfCandidates > toMatch){
                startPoint++;
                preambleSize = preambleDefaultSize;
            }else {
                System.out.println("The resulting set is : " + candidates.stream().map(String::valueOf).collect(joining(",")));
                System.out.println("The sum: " + sumOfCandidates);
                Long calculatedWeakness = candidates.stream().reduce(Long::max).orElse(0L) + candidates.stream().reduce(Long::min).orElse(0L);
                System.out.println("calculated weakness: " + calculatedWeakness);
                isAMatch = true;
            }
        }
    }

}
