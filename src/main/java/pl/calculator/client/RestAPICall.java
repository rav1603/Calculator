package pl.calculator.client;

import java.net.http.HttpResponse;

public interface RestAPICall {

    public HttpResponse<String> getHttpResponse(int min, int max);

}
