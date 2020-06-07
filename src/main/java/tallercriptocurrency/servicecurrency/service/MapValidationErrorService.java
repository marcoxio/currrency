package tallercriptocurrency.servicecurrency.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult result){

        if (result.hasErrors()) {
            //Java7
            /*
            Map<String,String> errorMap = new HashMap<>();
            for (FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());

            }
            */

            //Java8
            //lambda
            Map<String,String> errorMap = result.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
