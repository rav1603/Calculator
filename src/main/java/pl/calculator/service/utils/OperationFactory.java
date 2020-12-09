package pl.calculator.service.utils;

import pl.calculator.service.OperationStrategy;
import pl.calculator.service.OperationStrategyAdd;

import java.util.Arrays;

import static pl.calculator.service.utils.Operation.ADD;

public class OperationFactory {

    public OperationStrategy getOperation(String operationType) {
        if (ADD.getValue().equals(operationType)) {
            return new OperationStrategyAdd();
        } else {
            throw new UnsupportedOperationException("We don't support given operation yet. Allowed operations are: "
                    + Arrays.toString(Operation.values()));
        }
    }

}
