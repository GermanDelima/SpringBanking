package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.Services.TransferService;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController { private final  TransferService service;
public TransferController(TransferService service){
    this.service = service;
}

@PostMapping
public ResponseEntity<TransferDTO> performTransfer(@RequestBody TransferDTO dto){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.performTransfer(dto));
}

@GetMapping("/{id}")
public ResponseEntity<TransferDTO> getTransferById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.getTransferById(id));
}

@GetMapping
public ResponseEntity<List<TransferDTO>> getTransfers(){
    List<TransferDTO> lista = service.getTransfers();
    return ResponseEntity.status(HttpStatus.OK).body(lista);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
}


}
