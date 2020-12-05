package pl.calculator.client.rest.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

class ParameterBuilderTest {

    ParameterBuilder parameterBuilder = new ParameterBuilder();

    @Test
    void shouldReturnStringContainingAllParametersGivenInMap() {
        Map<String, String> params = Map.of("param1", "1", "param2", "2");
        String result = parameterBuilder.getParamsString(params);

        Assertions.assertThat(result).contains("param2=2").contains("param1=1");
    }

    @Test
    void shouldReturnEmptyStringWhenEmptyMapIsGiven() {
        String result = parameterBuilder.getParamsString(Collections.emptyMap());

        Assertions.assertThat(result).isEmpty();
    }
}