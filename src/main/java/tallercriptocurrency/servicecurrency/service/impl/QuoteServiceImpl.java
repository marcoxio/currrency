package tallercriptocurrency.servicecurrency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tallercriptocurrency.servicecurrency.domain.Quote;
import tallercriptocurrency.servicecurrency.domain.TipoDivisa;
import tallercriptocurrency.servicecurrency.exceptions.CurrencyIdException;
import tallercriptocurrency.servicecurrency.repository.QuoteRepository;
import tallercriptocurrency.servicecurrency.service.QuoteService;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public List<Quote> listAllQuote() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote createQuote(Quote quote) {
        try{
            TipoDivisa.validarTipoDivisa(quote.getSymbol());
            return quoteRepository.save(quote);
        }
        catch (CurrencyIdException c) {
            throw c;
        }catch(Exception e){
            throw new CurrencyIdException("Quote Name: '" + quote.getName() + "' ya existe");
        }

    }
}
