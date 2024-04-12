package feature.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DuplicationUserInformationException extends Throwable {

    private final HttpStatus status;

    public DuplicationUserInformationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
