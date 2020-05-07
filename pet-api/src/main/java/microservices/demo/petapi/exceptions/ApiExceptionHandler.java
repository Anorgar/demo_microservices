package microservices.demo.petapi.exceptions;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
public class ApiExceptionHandler implements ExceptionHandler<ApiException, HttpResponse> {

    @Override
    public HttpResponse<microservices.demo.petapi.exceptions.ApiError> handle(HttpRequest request, ApiException exception) {
        MutableHttpResponse<microservices.demo.petapi.exceptions.ApiError> response = HttpResponse.status(HttpStatus.valueOf(exception.getStatus()));
        response.body(ApiError.builder().message(exception.getMessage())
                .build());
        return response;
    }
}