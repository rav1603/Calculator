package pl.calculator.service;

import pl.calculator.service.utils.OperationHelper;

import java.util.List;

public class OperationStrategyAdd implements OperationStrategy {

    @Override
    public String execute(List<String> values) {
        return String.valueOf(values.stream()
                .mapToInt(OperationHelper::parseInt)
                .sum());
    }
}
