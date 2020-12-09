package pl.calculator.source;

import pl.calculator.source.utils.ParameterBuilder;
import pl.calculator.source.utils.RestAPICall;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ValueGeneratorRandomOrg implements ValueGenerator {

    RestAPICall restAPICall;
    private static final Map<String, String> CONSTANT_PARAMS = Map
            .of("num", "1",
                    "col", "1",
                    "base", "10",
                    "format", "plain",
                    "rnd", "new",
                    "min", "0",
                    "max", "100");
    private static final String RANDOM_ORG_URL = "https://www.random.org/integers/?";


    public ValueGeneratorRandomOrg(RestAPICall restAPICall) {
        this.restAPICall = restAPICall;
    }

    @Override
    public String getRandomValue() {
        HttpResponse<String> response = restAPICall.getHttpResponse(getURL());

        if (response != null && response.statusCode() == 200) {
            return response.body().trim();
        } else {
            throw new IllegalStateException("Something went wrong.. Try again later..");
        }
    }

    private String getURL() {
        Map<String, String> parameters = new HashMap<>(CONSTANT_PARAMS);

        ParameterBuilder parameterBuilder = new ParameterBuilder();
        String paramsString = parameterBuilder.getParamsString(parameters);
        return RANDOM_ORG_URL + paramsString;
    }


}
