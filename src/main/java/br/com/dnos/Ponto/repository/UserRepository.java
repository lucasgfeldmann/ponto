package br.com.dnos.Ponto.repository;

import br.com.dnos.Ponto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<UserDetails> findByEmail(String email);
}
