package tallercriptocurrency.servicecurrency.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_currency")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Currency implements Serializable {
    private static final long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombre de la criptomoneda es requerido")
    @Column(unique = true, nullable = false)
    private String name;
    @NotBlank(message = "Siglas de la criptomoneda es requerido")
    @Column(unique = true, nullable = false)
    private String symbol;
    private int rank;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    List<Quote> quote;
}
