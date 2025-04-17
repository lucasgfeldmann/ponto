package br.com.dnos.Ponto.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RecordResponse(Long id, LocalDateTime startAt, LocalDateTime endAt) {
}
