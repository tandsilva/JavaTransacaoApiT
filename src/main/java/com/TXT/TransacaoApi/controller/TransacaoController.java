package com.TXT.TransacaoApi.controller;

import com.TXT.TransacaoApi.business.services.TransacaoService;
import com.TXT.TransacaoApi.controller.dtos.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService transacaoService;
    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDto dto){
        transacaoService.adicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping
    public ResponseEntity<Void>deletarTrasacoes(){
        transacaoService.limparTrasacoes();
        return ResponseEntity.ok().build();
    }





}
