package pl.calculator.service;

public class CombiningStrategyAdd implements CombiningStrategy {

    @Override
    public int execute(int firstNumber, int secondNumber) {
        return Math.addExact(firstNumber, secondNumber);
    }
}
