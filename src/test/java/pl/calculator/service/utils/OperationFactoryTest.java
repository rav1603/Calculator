package pl.calculator.service.utils;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.calculator.service.OperationStrategy;
import pl.calculator.service.OperationStrategyAdd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationFactoryTest {

    OperationFactory operationFactory = new OperationFactory();

    @Test
    @Tag("UnitTest")
    void shouldCreateAddStrategyWhenAddOperationTypeIsGiven() {
        OperationStrategy result = operationFactory.getOperation("add");

        assertThat(result).isInstanceOf(OperationStrategyAdd.class);
    }

    @Test
    @Tag("UnitTest")
    void shouldThrowExceptionWhenNotSupportedOperationTypeIsGiven() {
        assertThatThrownBy(() -> operationFactory.getOperation("divide"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("We don't support given operation yet. Allowed operations are: "
                        + Arrays.toString(Operation.values()));
    }
}