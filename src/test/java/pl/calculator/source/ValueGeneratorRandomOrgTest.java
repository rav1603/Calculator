package pl.calculator.source;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.calculator.source.utils.RestAPICall;
import pl.calculator.source.utils.RestAPICallImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class ValueGeneratorRandomOrgTest {

    RestAPICall restAPICall = mock(RestAPICall.class);
    ValueGeneratorRandomOrg generator = new ValueGeneratorRandomOrg(restAPICall);

    @Test
    @Tag("UnitTest")
    void shouldPassWhenGivenURLIsValid() {
        ValueGeneratorRandomOrg numberOrgGenerator = new ValueGeneratorRandomOrg(new RestAPICallImpl());
        String result = new ValueGeneratorRandomOrg(new RestAPICallImpl()).getRandomValue();

        Assertions.assertThat(Integer.parseInt(result)).isGreaterThan(0).isLessThanOrEqualTo(10);
    }

    @Test
    @Tag("UnitTest")
    void shouldThrowExceptionWhenResponseIsNull() {
        assertThatThrownBy(() -> generator.getRandomValue())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Something went wrong.. Try again later..");
    }
}