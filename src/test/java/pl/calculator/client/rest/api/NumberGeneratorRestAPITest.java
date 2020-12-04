package pl.calculator.client.rest.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.calculator.client.rest.api.NumberGeneratorRestAPI;
import pl.calculator.client.rest.api.RestAPICall;
import pl.calculator.client.rest.api.RestAPICallImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class NumberGeneratorRestAPITest {

    RestAPICall restAPICall = mock(RestAPICall.class);
    NumberGeneratorRestAPI generator = new NumberGeneratorRestAPI(restAPICall);

    @Test
    void shouldReturnValueWhenValidRangeIsGiven() {
        NumberGeneratorRestAPI numberGeneratorRestAPI = new NumberGeneratorRestAPI(new RestAPICallImpl());
        int result = new NumberGeneratorRestAPI(new RestAPICallImpl()).getAnyNumberBetween(0, 10);

        Assertions.assertThat(result).isGreaterThan(0).isLessThanOrEqualTo(10);
    }

    @Test
    void shouldThrowExceptionWhenMinIsEqualsToMax() {
        assertThatThrownBy(() -> generator.getAnyNumberBetween(0, 0))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Max should be greater than min.");
    }

    @Test
    void shouldThrowExceptionWhenMinIsGreaterThanMax() {
        assertThatThrownBy(() -> generator.getAnyNumberBetween(10, 0))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Max should be greater than min.");
    }

    @Test
    void shouldThrowExceptionWhenResponseIsNull() {
        assertThatThrownBy(() -> generator.getAnyNumberBetween(0, 10))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Something went wrong.. Try again later..");
    }
}