package pl.calculator.client;

import java.util.Random;

public class NumberGeneratorJavaAPI implements NumberGenerator {
    @Override
    public int getAnyNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
}
