package pl.calculator.client.rest.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RestAPICallImpl implements RestAPICall {

    private static final Map<String, String> CONSTANT_PARAMS = Map
            .of("num", "1",
                    "col", "1",
                    "base", "10",
                    "format", "plain",
                    "rnd", "new");
    private static final String RANDOM_ORG_URL = "https://www.random.org/integers/?";
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    @Override
    public HttpResponse<String> getHttpResponse(int min, int max) {
        HttpRequest request = getHttpRequest(min, max);

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private HttpRequest getHttpRequest(int min, int max) {
        Map<String, String> parameters = new HashMap<>(CONSTANT_PARAMS);
        parameters.put("min", "" + min);
        parameters.put("max", "" + max);

        ParameterBuilder parameterBuilder = new ParameterBuilder();
        String paramsString = parameterBuilder.getParamsString(parameters);

        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(RANDOM_ORG_URL + paramsString))
                .build();
    }

}
