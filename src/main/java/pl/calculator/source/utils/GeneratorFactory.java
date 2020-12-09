package pl.calculator.source.utils;

import pl.calculator.source.ValueGenerator;
import pl.calculator.source.ValueGeneratorJavaAPI;
import pl.calculator.source.ValueGeneratorRandomOrg;

import java.util.Arrays;

public class GeneratorFactory {

    public ValueGenerator getGenerator(String source) {
        if (Source.JAVA_API.getValue().equals(source)) {
            return new ValueGeneratorJavaAPI();
        } else if (Source.RANDOM_ORG.getValue().equals(source)) {
            return new ValueGeneratorRandomOrg(new RestAPICallImpl());
        } else {
            throw new UnsupportedOperationException("We don't support given source yet. Allowed sources are: "
                    + Arrays.toString(Source.values()));
        }
    }

}
