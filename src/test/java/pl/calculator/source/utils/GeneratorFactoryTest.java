package pl.calculator.source.utils;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.calculator.source.ValueGenerator;
import pl.calculator.source.ValueGeneratorJavaAPI;
import pl.calculator.source.ValueGeneratorRandomOrg;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneratorFactoryTest {

    GeneratorFactory generatorFactory = new GeneratorFactory();

    @Test
    @Tag("UnitTest")
    void shouldCreateJavaAPISourceWhenJavaAPIStringIsGiven() {
        ValueGenerator result = generatorFactory.getGenerator("JavaAPI");

        assertThat(result).isInstanceOf(ValueGeneratorJavaAPI.class);
    }

    @Test
    @Tag("UnitTest")
    void shouldCreateJavaAPISourceWhenRandomOrgStringIsGiven() {
        ValueGenerator result = generatorFactory.getGenerator("random.org");

        assertThat(result).isInstanceOf(ValueGeneratorRandomOrg.class);
    }

    @Test
    @Tag("UnitTest")
    void shouldThrowExceptionWhenNotSupportedSourceIsGiven() {
        assertThatThrownBy(() -> generatorFactory.getGenerator("unknown_operation"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("We don't support given source yet. Allowed sources are: "
                        + Arrays.toString(Source.values()));
    }
}