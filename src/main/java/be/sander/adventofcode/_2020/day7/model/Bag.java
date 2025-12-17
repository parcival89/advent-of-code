package be.sander.adventofcode._2020.day7.model;

import be.sander.adventofcode._2020.ValueObject;

public class Bag extends ValueObject {
    private final String adverb;
    private final String color;

    private Bag(String adverb, String color) {
        this.adverb = adverb;
        this.color = color;
    }

    public static Bag of(String adverb, String color) {
        return new Bag(adverb, color);
    }

    public static Bag of(String colorWithAdverb) {
        String[] split = colorWithAdverb.trim().split(" ");
        return Bag.of(split[0], split[1]);
    }
}
