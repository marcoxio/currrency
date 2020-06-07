package tallercriptocurrency.servicecurrency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tallercriptocurrency.servicecurrency.domain.Currency;
import tallercriptocurrency.servicecurrency.domain.Quote;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    public Currency findByName(String name);
}
