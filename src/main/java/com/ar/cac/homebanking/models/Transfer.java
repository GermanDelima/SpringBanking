package com.ar.cac.homebanking.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transfer")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Trasnsfer Id")
    private Long id;

    private Long origin; //origen
    private Long target; //destino
    private Date date; //fecha
    private BigDecimal amount; //monto


}
