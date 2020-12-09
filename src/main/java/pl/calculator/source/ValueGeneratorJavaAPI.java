package pl.calculator.source;

import java.util.Random;

public class ValueGeneratorJavaAPI implements ValueGenerator {
    @Override
    public String getRandomValue() {
        Random random = new Random();
        return String.valueOf(random.nextInt());
    }
}
