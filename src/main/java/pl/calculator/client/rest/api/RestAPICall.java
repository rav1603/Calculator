package pl.calculator.client.rest.api;

import java.net.http.HttpResponse;

public interface RestAPICall {

    public HttpResponse<String> getHttpResponse(int min, int max);

}
