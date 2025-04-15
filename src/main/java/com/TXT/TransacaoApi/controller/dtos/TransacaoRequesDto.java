package com.TXT.TransacaoApi.controller.dtos;

import com.TXT.TransacaoApi.infrastructure.exceptions.UnprocessableEntity;

import java.time.OffsetDateTime;

public record TransacaoRequesDto(Double valor, OffsetDateTime dataHora) {

}
