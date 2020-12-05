package pl.calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.calculator.client.NumberGenerator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculatorTest {

    NumberGenerator generator = mock(NumberGenerator.class);
    Calculator calculator = new Calculator(generator, generator);

    @Test
    void shouldAddGeneratedNumbersWhenADDStrategyIsSelected() {
        when(generator.getAnyNumberBetween(0, 10)).thenReturn(2);

        int result = calculator.add(0, 10, Operation.ADD);

        Assertions.assertThat(result).isEqualTo(4);
    }

}