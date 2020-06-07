package tallercriptocurrency.servicecurrency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;
import tallercriptocurrency.servicecurrency.exceptions.CurrencyIdException;
import tallercriptocurrency.servicecurrency.repository.CurrencyRepository;
import tallercriptocurrency.servicecurrency.service.CurrencyService;

import java.util.List;


@Service
public class CurrencyServiceImpl implements CurrencyService {



    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> listAllCurrency() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findByName(String name) {
        Currency currency = currencyRepository.findByName(name);
        if(currency==null){
            throw  new CurrencyIdException("No se encontró el currency con el nombre : " + name);
        }
            //return currencyRepository.findByName(name);
        return currency;

    }


    @Override
    public Currency createCurrency(Currency currency) {
        try{
            return currencyRepository.save(currency);
        }catch(Exception e){
            throw new CurrencyIdException("Currency Name: '" + currency.getName() + "' ya existe");
        }

    }



}
