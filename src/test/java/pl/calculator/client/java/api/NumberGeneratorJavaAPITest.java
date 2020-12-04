package pl.calculator.client.java.api;

import org.junit.jupiter.api.Test;
import pl.calculator.client.java.api.NumberGeneratorJavaAPI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorJavaAPITest {

    NumberGeneratorJavaAPI numberGeneratorJavaAPI = new NumberGeneratorJavaAPI();


    @Test
    void shouldReturnValueInGivenRange() {
        int result = numberGeneratorJavaAPI.getAnyNumberBetween(0, 10);

        assertThat(result).isGreaterThan(0).isLessThanOrEqualTo(10);
    }

    @Test
    void shouldPassWhenMinIsEqualsToMax() {
        int result = numberGeneratorJavaAPI.getAnyNumberBetween(0, 0);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldThrowAnExceptionWhenMinIsGreaterThanMax() {
        assertThatThrownBy(() -> numberGeneratorJavaAPI.getAnyNumberBetween(10, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}