package pl.calculator.source.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RestAPICallImpl implements RestAPICall {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    @Override
    public HttpResponse<String> getHttpResponse(String stringURL) {
        HttpRequest request = getHttpRequest(stringURL);

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private HttpRequest getHttpRequest(String stringURL) {

        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(stringURL))
                .build();
    }

}
