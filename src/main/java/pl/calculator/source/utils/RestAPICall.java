package pl.calculator.source.utils;

import java.net.http.HttpResponse;

public interface RestAPICall {

    HttpResponse<String> getHttpResponse(String stringURL);

}
