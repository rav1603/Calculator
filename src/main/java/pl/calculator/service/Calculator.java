package pl.calculator.service;

import pl.calculator.client.NumberGenerator;

public class Calculator {

    private CombiningStrategy combiningStrategy;
    private final NumberGenerator firstGenerator;
    private final NumberGenerator secondGenerator;

    public Calculator(NumberGenerator firstGenerator,
                      NumberGenerator secondGenerator) {
        this.firstGenerator = firstGenerator;
        this.secondGenerator = secondGenerator;
    }

    public int add(int min, int max, Operation operation) {
        setOperation(operation);
        return combiningStrategy
                .execute(firstGenerator.getAnyNumberBetween(min, max),
                        secondGenerator.getAnyNumberBetween(min, max));

    }

    private void setOperation(Operation operation) {
        switch (operation) {
            case ADD:
                setCombiningStrategy(new CombiningStrategyAdd());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }

    public void setCombiningStrategy(CombiningStrategy combiningStrategy) {
        this.combiningStrategy = combiningStrategy;
    }
}
