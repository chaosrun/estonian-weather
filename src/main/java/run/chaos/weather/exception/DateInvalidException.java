package run.chaos.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DateInvalidException extends RuntimeException {
    @Override
    public String getMessage() {
        return message;
    }

    private final String message;
    public DateInvalidException(String message) {
        this.message=message;
    }
}
