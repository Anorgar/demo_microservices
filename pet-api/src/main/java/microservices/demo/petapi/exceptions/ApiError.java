package microservices.demo.petapi.exceptions;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiError {

    private int status;
    private String message;

}
