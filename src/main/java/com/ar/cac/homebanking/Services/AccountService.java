package com.ar.cac.homebanking.Services;

import com.ar.cac.homebanking.Repositories.AccountRepository;
import com.ar.cac.homebanking.mappers.AccountMapper;
import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.dtos.AccountDTO;
import com.ar.cac.homebanking.models.enums.AccountType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    final private AccountRepository repository;
    public AccountService(AccountRepository repository){
        this.repository = repository;
    }


    public List<AccountDTO> getAccounts() {
        List<Account> accounts = repository.findAll();
       return accounts.stream()
                .map(AccountMapper::accountToDto)
                .collect(Collectors.toList());

    }

    public AccountDTO getAccountById(Long id) {
       Account account = repository.findById(id).get();
       return AccountMapper.accountToDto(account);
    }

    public AccountDTO createAccount(AccountDTO dto) {
       dto.setType(AccountType.CAJA_AHORRO); //se setea antes de guardar en la base de datos
       dto.setAmount(BigDecimal.ZERO);
       Account account = repository.save(AccountMapper.dtoToAccount(dto));
       return AccountMapper.accountToDto(account);
    }
}
