package tallercriptocurrency.servicecurrency;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sun.util.calendar.BaseCalendar;
import tallercriptocurrency.servicecurrency.controller.CurrencyController;
import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;
import tallercriptocurrency.servicecurrency.service.CurrencyService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyController.class)
public class ServiceCurrencyApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    //Currency mockCurrency = new Currency(1L, "Tether", "USDT", 0, new List<Quote>(1L, "Dolar Americano", "USD", 7600.0, new SimpleDateFormat("yyyy-MM-dd")) {

    Currency mockCurrency = new Currency();

    String exampleCurrencyJson = "{\"name\":\"Tether\",\"symbol\":\"USDT\",\"rank\":\"1\",\"quote\":[\"\"]}";

    @Test
    public void ObtenerDetallesCurrency() throws Exception
    {
        Mockito.when(
                currencyService.findByName(Mockito.anyString())).thenReturn(mockCurrency);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/Bitcoin").accept(
                MediaType.APPLICATION_JSON
                );

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{id:1,name:Tether,symbol:USDT,rank:0}";

        JSONAssert.assertEquals(expected, result.getResponse()
                                .getContentAsString(),false );

    }
}
