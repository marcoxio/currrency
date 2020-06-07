package tallercriptocurrency.servicecurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;
import tallercriptocurrency.servicecurrency.service.CurrencyService;
import tallercriptocurrency.servicecurrency.service.MapValidationErrorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private MapValidationErrorService validationErrorService;


    @GetMapping(value = "/{name}")
    public ResponseEntity<?> getCurrency(@PathVariable("name") String name){
        Currency currency = currencyService.findByName(name);
        if(currency==null){
           return new ResponseEntity(currency, HttpStatus.NOT_FOUND);
            //return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok(currency);
        return new ResponseEntity(currency, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<?>> listAllCurrency(){
        List<Currency> currencies = currencyService.listAllCurrency() ;
        if(currencies.isEmpty()){
           // return ResponseEntity.notFound().build();
            return new ResponseEntity(currencies, HttpStatus.NOT_FOUND);
        }
        //return ResponseEntity.ok(currencies);
        return new ResponseEntity(currencies, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<?> createCurrency(@Valid @RequestBody Currency currency, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Currency currencyCreated = currencyService.createCurrency(currency);
        return new ResponseEntity(currencyCreated, HttpStatus.CREATED);
       /* try {
            Currency currencyCreated = currencyService.createCurrency(currency);
            return ResponseEntity.status(HttpStatus.CREATED).body(currencyCreated);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

        */

    }



}
