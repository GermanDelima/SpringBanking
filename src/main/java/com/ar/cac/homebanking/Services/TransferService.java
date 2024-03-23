package com.ar.cac.homebanking.Services;
import com.ar.cac.homebanking.Repositories.AccountRepository;
import com.ar.cac.homebanking.Repositories.TransferRepository;
import com.ar.cac.homebanking.exceptions.AccountNotFoundException;
import com.ar.cac.homebanking.exceptions.InsufficientFoundsException;
import com.ar.cac.homebanking.exceptions.TransferNotFoundException;
import com.ar.cac.homebanking.mappers.TransferMapper;
import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.Transfer;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {
    private final TransferRepository repository;
    private final AccountRepository accountRepository;

    public TransferService(TransferRepository repository, AccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    public List<TransferDTO> getTransfers() {
        List<Transfer> transfers = repository.findAll();
        return transfers.stream()
                .map(TransferMapper::TransferToDto)
                .collect(Collectors.toList());
    }

    public TransferDTO getTransferById(Long id) {
        if (repository.existsById(id)) {
            Transfer transfer = repository.findById(id).get();
            TransferMapper.TransferToDto(transfer);
        }
        throw new TransferNotFoundException("Transfer not found with id: " + id);
    }

    public String deleteTransfer(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Se ha eliminado la transferencia";
        } else {
            return "No se ha eliminado la transferencia";
        }
    }

    @Transactional
    public TransferDTO performTransfer(TransferDTO dto) {
        //Comprobar si las cuentas de origen y destino existen
        Account originAccount = accountRepository.findById(dto.getOrigin())
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + dto.getOrigin()));
        Account destinationAccount = accountRepository.findById(dto.getTarget())
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + dto.getTarget()));

        //Comprobar si la cuenta de origen tiene fondo suficiente
        if (originAccount.getAmount().compareTo(dto.getAmount()) < 0) {
            throw new InsufficientFoundsException("Insufficient funds in the account with id " + dto.getOrigin());
        }
        //Realizar la transferencia
        originAccount.setAmount(originAccount.getAmount().subtract(dto.getAmount()));
        destinationAccount.setAmount(destinationAccount.getAmount().add(dto.getAmount()));

        //Guardar las cuentas actualizadas
        accountRepository.save(originAccount);
        accountRepository.save(destinationAccount);

        //crear la transferencia y guardarla en la base de datos
        Transfer transfer = new Transfer();
        //Creamos un objeto del tipo Date para obtener la fecha actual
        Date date = new Date();
        //Seteamos el objeto fecha actual en el transferDto
        transfer.setDate(date);
        transfer.setOrigin(originAccount.getId());
        transfer.setTarget(destinationAccount.getId());
        transfer.setAmount(dto.getAmount());
        transfer = repository.save(transfer);

        //Devolvemos el DTO de la transferencia realizada
        return TransferMapper.TransferToDto(transfer);
    }
}


