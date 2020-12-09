package pl.calculator.service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationStrategyAddTest {

    OperationStrategyAdd add = new OperationStrategyAdd();

    @Test
    @Tag("UnitTest")
    void shouldSumAllValuesFromTheList() {
        String result = add.execute(List.of("2", "2", "3", "3"));

        assertThat(result).isEqualTo("10");
    }

    @Test
    @Tag("UnitTest")
    void shouldThrowExceptionWhenValueCantBeParseToInt() {
        assertThatThrownBy(() -> add.execute(List.of("2", "asd", "2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value incompatible with operation type.");
    }
}