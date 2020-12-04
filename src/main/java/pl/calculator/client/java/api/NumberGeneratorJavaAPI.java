package pl.calculator.client.java.api;

import pl.calculator.client.NumberGenerator;

import java.util.Random;

public class NumberGeneratorJavaAPI implements NumberGenerator {
    @Override
    public int getAnyNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
}
