package tallercriptocurrency.servicecurrency.service;

import org.springframework.data.jpa.repository.JpaRepository;
import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;

import java.util.List;


public interface CurrencyService {


    public List<Currency> listAllCurrency();
    public Currency findByName(String name);
    public Currency createCurrency(Currency currency);

}
