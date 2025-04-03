package br.com.dnos.Ponto.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record UserRequest(@NotEmpty(message = "Nome é obrigatorio") String name,
                          @Email(message = "Email mal formatado") String email,
                          @NotEmpty(message = "Senha é obrigatória") String password) {
}
