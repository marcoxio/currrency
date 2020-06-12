package tallercriptocurrency.servicecurrency;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tallercriptocurrency.servicecurrency.controller.CurrencyController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceCurrencyApplicationTests {

    @Autowired
    private CurrencyController controller;


    @Test
    public void contextLoads() {
       // assertThat(controller).isNotNull();
    }

}
