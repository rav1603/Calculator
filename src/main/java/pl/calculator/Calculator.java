package pl.calculator;

import pl.calculator.service.OperationStrategy;
import pl.calculator.service.utils.OperationFactory;
import pl.calculator.source.ValueGenerator;
import pl.calculator.source.utils.GeneratorFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public String run(String[] args) {

        validation(args);

        OperationStrategy operation = new OperationFactory().getOperation(args[0]);

        List<String> values = Arrays.stream(args)
                .skip(1)
                .map(source -> new GeneratorFactory().getGenerator(source))
                .map(ValueGenerator::getRandomValue)
                .collect(Collectors.toList());

        return operation.execute(values);
    }

    private void validation(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("At least 3 arguments are required: operation + two or more sources");
        }
    }
}
