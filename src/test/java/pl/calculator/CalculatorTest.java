package pl.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @Tag("IntegrationTest")
    void shouldAddGeneratedNumbersWhenValidInputIsGiven() {
        String result = calculator.run(new String[]{"add", "JavaAPI", "random.org"});

        Assertions.assertThat(result).isNotEmpty();
    }

    @Test
    @Tag("UnitTest")
    void shouldThrowExceptionWhenInvalidNumberOfParametersAreGiven() {
        Assertions.assertThatThrownBy(() -> calculator.run(new String[]{"param1", "param2"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("At least 3 arguments are required: operation + two or more sources");
    }

}