package be.sander.adventofcode._2020.day2.model;

public class Range {
    private final Long bottom;
    private final Long top;

    public Range(String range) {
        String[] split = range.split("-");
        this.bottom = Long.parseLong(split[0].trim());
        this.top = Long.parseLong(split[1].trim());
    }

    public boolean isInRange(Long number){
        return bottom <= number && number <= top;
    }
}