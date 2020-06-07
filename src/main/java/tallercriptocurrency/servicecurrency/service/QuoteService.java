package tallercriptocurrency.servicecurrency.service;

import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;

import java.util.List;

public interface QuoteService {

    public List<Quote> listAllQuote();
    public Quote createQuote(Quote quote);
}
