package pl.calculator.client;

import java.net.http.HttpResponse;

public class NumberGeneratorRestAPI implements NumberGenerator {

    RestAPICall restAPICall;

    public NumberGeneratorRestAPI(RestAPICall restAPICall) {
        this.restAPICall = restAPICall;
    }

    @Override
    public int getAnyNumberBetween(int min, int max) {
        if (min >= max) {
            throw new IllegalStateException("Max should be greater than min.");
        }

        HttpResponse<String> response = restAPICall.getHttpResponse(min, max);

        if (response != null && response.statusCode() == 200) {
            return Integer.parseInt(response.body().trim());
        } else {
            throw new IllegalStateException("Something went wrong.. Try again later..");
        }
    }


}
