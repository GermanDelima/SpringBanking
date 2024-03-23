package com.ar.cac.homebanking.mappers;


import com.ar.cac.homebanking.models.Transfer;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
@Builder
public class TransferMapper {

public Transfer dtoToTransfer(TransferDTO dto){
    return Transfer.builder()
            .origin(dto.getOrigin())
            .target(dto.getTarget())
            .amount(dto.getAmount())
            .date(dto.getDate())
            .build();
}

public TransferDTO TransferToDto(Transfer transfer){
    return TransferDTO.builder()
            .id(transfer.getId())
            .origin(transfer.getOrigin())
            .target(transfer.getTarget())
            .amount(transfer.getAmount())
            .date(transfer.getDate())
            .build();
}
}
