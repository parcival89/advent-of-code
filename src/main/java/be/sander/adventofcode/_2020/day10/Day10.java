package be.sander.adventofcode._2020.day10;

import be.sander.adventofcode._2020.FileUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Day10 {
    public static void main(String[] args) {
        Map<Integer, Integer> diffsCount = new HashMap<>();
        AtomicLong configurations = new AtomicLong(1);
        AtomicInteger onesStreak = new AtomicInteger();
        FileUtil.readFile("day10/puzzle2.txt").stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .reduce(0, (prev, next) -> {
                    reducePart1(prev, next, diffsCount);
                    reducePart2(prev, next, onesStreak, configurations);
                    return next;
                });
        // always diff of 3 at the end
        reducePart1(-3, 0, diffsCount);
        // handle case when sequence does not end with diff 3
        reducePart2(0, 0, onesStreak, configurations);

        System.out.printf("Pt 1: %d\n", diffsCount.getOrDefault(3, 0) * diffsCount.getOrDefault(1, 0));
        System.out.printf("Pt 2: %d\n", configurations.get());
    }

    private static void reducePart1(int prev, int next, Map<Integer, Integer> diffsCount) {
        int diff = next - prev;
        int existingCount = diffsCount.getOrDefault(diff, 0);
        diffsCount.put(diff, existingCount + 1);
    }

    private static void reducePart2(int prev, int next, AtomicInteger onesStreak, AtomicLong configurations) {
        if (next - prev == 1) {
            onesStreak.incrementAndGet();
        } else {
            int streak = onesStreak.get();
            configurations.set(configurations.get() * getConfigurationsCount(streak));
            onesStreak.set(0);
        }
    }

    // https://en.wikipedia.org/wiki/Lazy_caterer%27s_sequence
    private static long getConfigurationsCount(int streak) {
        streak = streak - 1; // only inner part of cluster can be changed - exclude last/first number
        return (((long) streak * streak) + streak + 2) / 2;
    }
}