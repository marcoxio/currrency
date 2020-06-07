package tallercriptocurrency.servicecurrency.domain;

import tallercriptocurrency.servicecurrency.exceptions.CurrencyIdException;

import java.util.Arrays;
import java.util.stream.Stream;

public enum TipoDivisa {
    USD,EUR,GBP;

    public static TipoDivisa validarTipoDivisa(String input){
        return Stream.of(TipoDivisa.values()).filter(tipoDivisa -> tipoDivisa.name().equals(input)).findAny().orElseThrow(() -> new CurrencyIdException(
                "Los valores para el tipo de divisa solo pueden ser :" + Arrays.asList(TipoDivisa.values())));
    }
}
