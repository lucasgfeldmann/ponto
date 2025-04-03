package br.com.dnos.Ponto.exception;

public class UsernameOrPasswordException extends RuntimeException {
    public UsernameOrPasswordException(String message) {
        super(message);
    }
}
