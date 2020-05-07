package microservices.demo.petapi.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private int status;

    public ApiException(String message, int status) {
        super(message);
        this.status = status;
    }
}
