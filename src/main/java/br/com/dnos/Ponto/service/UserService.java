package br.com.dnos.Ponto.service;

import br.com.dnos.Ponto.entity.User;
import br.com.dnos.Ponto.exception.EmailUsedException;
import br.com.dnos.Ponto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        Optional<UserDetails> findedUser = userRepository.findByEmail(user.getEmail());
        if (findedUser.isPresent()) {
            throw new EmailUsedException("O email ja está em uso.");
        }
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}
