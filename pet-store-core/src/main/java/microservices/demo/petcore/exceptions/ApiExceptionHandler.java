package libraries.microservices.micronaut.core.handlers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import javax.inject.Singleton;
import libraries.microservices.micronaut.core.exceptions.domains.ApiError;
import libraries.microservices.micronaut.core.exceptions.domains.ApiException;

@Produces
@Singleton
public class ApiExceptionHandler implements ExceptionHandler<ApiException, HttpResponse> {

  @Override
  public HttpResponse<ApiError> handle(HttpRequest request, ApiException exception) {
    MutableHttpResponse<ApiError> response = HttpResponse.status(HttpStatus.valueOf(Integer.parseInt(exception.getCode())));
    response.body(ApiError.builder().message(exception.getMessage())
        .errorDetails(exception.getErrorDetails())
        .build());
    return response;
  }
}
