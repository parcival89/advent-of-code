package be.sander.adventofcode._2020.day5.model;

abstract class Decoder {
    private final Integer bottomStart;
    private final Integer topStart;
    private final Character diminisher;
    private final Character augmenter;

    protected Decoder(Integer bottomStart, Integer topStart, Character diminisher, Character augmenter) {
        this.bottomStart = bottomStart;
        this.topStart = topStart;
        this.diminisher = diminisher;
        this.augmenter = augmenter;
    }

    public final Integer decode(String toDecode) {
        return decode(topStart, bottomStart, toDecode);
    }

    private Integer decode(Integer top, Integer bottom, String toDecode){
        if(toDecode.isEmpty()){
            return ((top + bottom) / 2);
        }
        Character info = toDecode.charAt(0);

        if (info == diminisher) {
            top -= (top - bottom + 1) / 2;
        } else if (info == augmenter) {
            bottom += (top - bottom + 1) / 2;
        } else throw new IllegalArgumentException("could not determine diminisher or augmenter: " + info);

        return decode(top, bottom, toDecode.substring(1));
    }
}
