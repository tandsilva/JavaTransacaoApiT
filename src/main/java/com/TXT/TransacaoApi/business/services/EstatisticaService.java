package com.TXT.TransacaoApi.business.services;

import com.TXT.TransacaoApi.controller.dtos.EstatisticasResponseDto;
import com.TXT.TransacaoApi.controller.dtos.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

//para fazer a injecao de dependencias do que for preciso
@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {
//porque sera preciso chamar ela para pegar as trasaçoes do ultimo minuto
    public final TransacaoService transacaoService;

    public EstatisticasResponseDto calcularEstatisticasTransacoes(Integer intervaloBusca){
        log.info("Iniciada busca de estatisticas de transações ");
        List<TransacaoRequestDto> transacoes = transacaoService.bucarTrasacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticaTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDto::valor).summaryStatistics();

        return new EstatisticasResponseDto(estatisticaTransacoes.getCount(),
                estatisticaTransacoes.getSum(),estatisticaTransacoes.getAverage(),
                estatisticaTransacoes.getMin(),estatisticaTransacoes.getMax());
    }



}
