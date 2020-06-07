package tallercriptocurrency.servicecurrency.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "tbl_quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Nombre del tipo de  moneda es requerido")
    @Column(unique = true, nullable = false)
    private String name;
    @NotEmpty(message = "Las siglas de la moneda es requerida")
    @Column(unique = true, nullable = false)
    //@Enumerated(EnumType.STRING)
    private String symbol;
    @Positive(message = "El valor debe ser mayor a 0")
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdate;





}
