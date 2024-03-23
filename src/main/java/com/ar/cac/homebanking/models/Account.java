package com.ar.cac.homebanking.models;
import com.ar.cac.homebanking.models.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuenta")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_type")
    private AccountType type;
    private String cbu;
    private String alias;
    private BigDecimal amount;
    @ManyToOne
    private User owner;



}
