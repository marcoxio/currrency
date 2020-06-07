package tallercriptocurrency.servicecurrency.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyIdException extends RuntimeException{

    public CurrencyIdException(String message) {
        super(message);
    }
}
