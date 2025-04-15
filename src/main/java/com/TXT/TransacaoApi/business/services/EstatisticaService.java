package com.TXT.TransacaoApi.business.services;

import com.TXT.TransacaoApi.controller.dtos.EstatisticasResponseDto;
import com.TXT.TransacaoApi.controller.dtos.TransacaoRequesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

//para fazer a injecao de dependencias do que for preciso
@Service
@RequiredArgsConstructor
public class EstatisticaService {
//porque sera preciso chamar ela para pegar as trasaçoes do ultimo minuto
    public final TransacaoService transacaoService;

    public EstatisticasResponseDto calcularEstatisticasTransacoes(Integer intervaloBusca){
        List<TransacaoRequesDto> transacoes = transacaoService.bucarTrasacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticaTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequesDto::valor).summaryStatistics();

        return new EstatisticasResponseDto(estatisticaTransacoes.getCount(),
                estatisticaTransacoes.getSum(),estatisticaTransacoes.getAverage(),
                estatisticaTransacoes.getMin(),estatisticaTransacoes.getMax());
    }



}
