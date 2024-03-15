package com.ar.cac.homebanking.mappers;

import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.dtos.AccountDTO;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.models.enums.AccountType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {
    //Metodo para pasar de AccountDTO a Entity y guardar en el Repository base de datos
        public Account dtoToAccount(AccountDTO dto){
        Account account = new Account();
        account.setType(dto.getType());
        account.setCbu(dto.getCbu());
        account.setAlias(dto.getAlias());
        account.setAmount(dto.getAmount());
        return account;
    }

    //Metodo para pasar de Entity a AccountDTO y mostrar via Json al Front

    public AccountDTO accountToDto(Account account){
    AccountDTO dto = new AccountDTO();
    dto.setId(account.getId());
    dto.setType(account.getType());
    dto.setCbu(account.getCbu());
    dto.setAlias(account.getAlias());
    dto.setAmount(account.getAmount());
    return dto;
    }
}
