package br.com.dnos.Ponto.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@Email(message = "Email mal formatado") String email,
                           @NotEmpty(message = "Senha é obrigatória") String password) {
}
