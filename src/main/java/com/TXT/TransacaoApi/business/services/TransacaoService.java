package com.TXT.TransacaoApi.business.services;

import com.TXT.TransacaoApi.controller.dtos.TransacaoRequesDto;
import com.TXT.TransacaoApi.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

//para fazer a injecao de dependencias do que for preciso
@Service
@RequiredArgsConstructor
//biblioteca de Logs
@Slf4j
public class TransacaoService {
    private final List<TransacaoRequesDto> ListaTransacoes = new ArrayList<>();


    public void adicionarTransacoes(TransacaoRequesDto dto){
        log.info("Iniciado processamento de gravar Transacoes");
        //vai pegar a data e hora atual e verificar se eh posterior a data atual
        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e Hora maiores que data atual");
            throw  new UnprocessableEntity("Data e Hora maiores que data atual");
        }
        if(dto.valor()<0){
            log.error("Valor nao pode ser menor que 0");
            throw new UnprocessableEntity("Valor nao pode ser menor que 0");
        }
        ListaTransacoes.add(dto);
    }
    public void limparTrasacoes(){
        ListaTransacoes.clear();
    }

    public List<TransacaoRequesDto>bucarTrasacoes(Integer intervaloBusca){
        //vai pegar todas as tramsacoes realizadas no ultimo minuto  ("OffsetDateTime.now()") menos ("intervaloBusca")
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return ListaTransacoes.stream()
                .filter(transacoes ->transacoes.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();
    }


}
