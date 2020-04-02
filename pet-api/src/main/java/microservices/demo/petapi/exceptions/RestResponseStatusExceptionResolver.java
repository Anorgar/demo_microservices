package microservices.demo.petapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseStatusExceptionResolver extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ApiException.class})
  public ResponseEntity<ApiError> handleApiException(ApiException ex) {

    return ResponseEntity.status(ex.getStatus())
        .header(HttpHeaders.CONTENT_TYPE, "application/api.error+json")
        .body(ApiError.builder().status(ex.getStatus()).message(ex.getMessage()).build());
  }

}
