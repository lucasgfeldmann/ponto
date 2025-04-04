package br.com.dnos.Ponto.controller;


import br.com.dnos.Ponto.controller.request.LoginRequest;
import br.com.dnos.Ponto.controller.request.UserRequest;
import br.com.dnos.Ponto.controller.response.LoginResponse;
import br.com.dnos.Ponto.controller.response.UserResponse;
import br.com.dnos.Ponto.entity.User;
import br.com.dnos.Ponto.exception.EmailUsedException;
import br.com.dnos.Ponto.exception.UsernameOrPasswordException;
import br.com.dnos.Ponto.mapper.UserMapper;
import br.com.dnos.Ponto.service.TokenService;
import br.com.dnos.Ponto.service.UserService;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "auth")
@Schema(name = "auth")
@RequiredArgsConstructor
@Validated
public class AuthController implements AuthControllerDocs {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    @PostMapping("register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(userService.save(UserMapper.toUser(userRequest))));
    }

    @Override
    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);
            User user = (User) authentication.getPrincipal();
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok().body(new LoginResponse(token));
        } catch (BadCredentialsException error) {
            throw new UsernameOrPasswordException("Usuario ou senha invalido.");
        }

    }


}
