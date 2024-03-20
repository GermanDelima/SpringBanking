package com.ar.cac.homebanking.models.dtos;

import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;
import java.math.BigDecimal;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long id;
    private AccountType type;
    private String cbu;
    private String alias;
    private BigDecimal amount;
    private User Owner;
}
