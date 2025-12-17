package be.sander.adventofcode._2020.day4.model.validation;

import java.util.Arrays;

public class Height extends Validation<String> {
    public Height(String height) {
        super(height);
    }

    @Override
    boolean validateSpecifics() {
        Metric metric = Metric.fromIdentifier(this.value);
        if(metric == null){
            return false;
        }

        int height = parseHeight(this.value);
        if (metric == Metric.CM){
            return height > 149 && height < 194;
        }else if(metric == Metric.IN){
            return height > 58 && height < 77;
        }
        return false;
    }

    private Integer parseHeight(String height) {
        String valueAsString = height.substring(0, height.length() - 2);
        return Integer.parseInt(valueAsString);
    }

    private enum Metric{
        CM("cm"),IN("in");

        private final String identifier;

        Metric(String identifier) {
            this.identifier = identifier;
        }

        public static Metric fromIdentifier(String identifier){
            return Arrays.stream(values())
                    .filter(metric -> identifier.endsWith(metric.identifier))
                    .findAny()
                    .orElse(null);
        }
    }
}
