package be.sander.adventofcode._2020.day7.model;

import be.sander.adventofcode._2020.ValueObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BagRule extends ValueObject {
    private final Bag bag;
    private final Integer amount;
    private final List<BagRule> containedBags;

    private BagRule(Bag bag, Integer amount, List<BagRule> containedBags) {
        this.bag = bag;
        this.amount = amount;
        this.containedBags = containedBags;
    }

    public static BagRule of(Bag bag, Integer amount) {
        return new BagRule(bag, amount, new ArrayList<>());
    }

    public Bag getBag() {
        return bag;
    }

    public Integer getAmount() {
        return amount;
    }

    public List<BagRule> getContainedBags() {
        return containedBags;
    }

    public BagRule containing(List<BagRule> bags) {
        containedBags.addAll(bags);
        List<BagRule> newContaining = List.copyOf(containedBags);
        return new BagRule(bag, amount, newContaining);
    }

    public boolean containsAny(Collection<Bag> bags) {
        return containedBags.stream()
                .anyMatch(containedBag -> bags.contains(containedBag.getBag()));
    }

    public Integer calculate() {
        return amount * containedBags.stream()
                .map(BagRule::calculate)
                .map(calculated -> amount * calculated)
                .reduce((value1, value2) -> value1*value2)
                .orElse(1);
    }
}
