package br.com.dnos.Ponto.controller;

import br.com.dnos.Ponto.controller.request.LoginRequest;
import br.com.dnos.Ponto.controller.request.UserRequest;
import br.com.dnos.Ponto.controller.response.LoginResponse;
import br.com.dnos.Ponto.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@Tag(name = "Authentication", description = "Rotas de autenticação")
public interface AuthControllerDocs {

    @Operation(summary = "Realiza o login do usuário e retorna o token JWT.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Login realizado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Email ou senha inválidos.",
                    content = @Content(mediaType = "application/json")
            )
    })
    ResponseEntity<LoginResponse> login(
            @Valid
            @RequestBody(
                    description = "Credenciais do usuário.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginRequest.class),
                            examples = @ExampleObject(
                                    name = "Login Exemplo",
                                    summary = "Exemplo de credenciais",
                                    value = """
                                                {
                                                    "email": "joao@email.com",
                                                    "password": "123456"
                                                }
                                            """
                            )

                    )
            )
            LoginRequest request
    );

    @Operation(summary = "Realiza o cadastro de usuários.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuário criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class),
                            examples = @ExampleObject(
                                    name = "Exemplo de resposta",
                                    summary = "Usuário criado",
                                    value = """
                                                {
                                                    "id": 1,
                                                    "name": "Lucas Silva",
                                                    "email": "lucas@example.com"
                                                }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requisição mal formatada ou dados inválidos.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Email está em uso, cadastre outro email.",
                    content = @Content(mediaType = "application/json")
            )
    })
    ResponseEntity<UserResponse> register(
            @Valid
            @RequestBody(
                    description = "Objeto com os dados do novo usuário.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserRequest.class),
                            examples = @ExampleObject(
                                    name = "Exemplo básico",
                                    summary = "Todos os campos obrigatórios",
                                    description = "O nome não pode estar em branco, o email deve estar bem formatado e a senha não pode ser nula.",
                                    value = """
                                             {
                                               "name": "João Silva",
                                               "email": "joao@email.com",
                                               "password": "123456"
                                             }
                                            """
                            )

                    )
            )
            UserRequest userRequest
    );
}
