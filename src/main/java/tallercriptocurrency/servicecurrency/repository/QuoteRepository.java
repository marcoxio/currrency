package tallercriptocurrency.servicecurrency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tallercriptocurrency.servicecurrency.domain.Quote;

public interface QuoteRepository extends JpaRepository<Quote,Long> {
}
