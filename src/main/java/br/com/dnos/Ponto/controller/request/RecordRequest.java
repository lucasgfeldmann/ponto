package br.com.dnos.Ponto.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record RecordRequest(@NotNull LocalDateTime startAt, LocalDateTime endAt) {
}
