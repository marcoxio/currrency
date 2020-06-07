package tallercriptocurrency.servicecurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;
import tallercriptocurrency.servicecurrency.service.MapValidationErrorService;
import tallercriptocurrency.servicecurrency.service.QuoteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private MapValidationErrorService validationErrorService;

    @GetMapping
    public ResponseEntity<List<Quote>> listAllQuote(){
        List<Quote> quotes = quoteService.listAllQuote() ;
        if(quotes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quotes);

    }

    @PostMapping
    public ResponseEntity<?> createQuote(@Valid @RequestBody Quote quote, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Quote quoteCreated = quoteService.createQuote(quote);
        return new ResponseEntity(quoteCreated, HttpStatus.CREATED);
        /*try {
            Quote quoteCreated = quoteService.createQuote(quote);
            return ResponseEntity.status(HttpStatus.CREATED).body(quoteCreated);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

         */

    }
}
