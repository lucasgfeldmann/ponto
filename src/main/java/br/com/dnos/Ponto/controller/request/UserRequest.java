package br.com.dnos.Ponto.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.UniqueElements;

@Builder
public record UserRequest(@NotNull @NotEmpty(message = "Nome é obrigatorio") String name,
                          @NotNull @Email(message = "Email mal formatado") String email,
                          @NotNull @NotEmpty(message = "Senha é obrigatória") String password) {
}
