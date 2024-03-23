package com.ar.cac.homebanking.models.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Builder
public class TransferDTO {
    private Long id;
    private Long origin;
    private Long target; //destino
    private Date date; //fecha
    private BigDecimal amount; //monto

}
