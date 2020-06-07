package tallercriptocurrency.servicecurrency.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handlerProjectException(CurrencyIdException ex, WebRequest request){
        //CurrencyIdExceptionResponse exceptionResponse = new CurrencyIdExceptionResponse(Long.valueOf(ex.getMessage()));
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
