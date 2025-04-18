package com.TXT.TransacaoApi.controller;

import com.TXT.TransacaoApi.business.services.EstatisticaService;
import com.TXT.TransacaoApi.controller.dtos.EstatisticasResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticaService estatisticaService;

    public ResponseEntity<EstatisticasResponseDto>buscarEstatisticas(
            @RequestParam(value = "intervaloBusca",required = false,defaultValue = "60")Integer intervaloBusca){
            return  ResponseEntity.ok(
                    estatisticaService.calcularEstatisticasTransacoes(intervaloBusca));



}}
