package br.com.dnos.Ponto.controller.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String name, String email) {
}
