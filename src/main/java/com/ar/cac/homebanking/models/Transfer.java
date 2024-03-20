package com.ar.cac.homebanking.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Trasnsfer Id")
    private Long id;
    private long origin;
    private Long target; //destino
    private Date date; //fecha
    private BigDecimal amount; //monto

}
