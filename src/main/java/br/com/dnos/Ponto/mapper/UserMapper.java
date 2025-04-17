package br.com.dnos.Ponto.mapper;

import br.com.dnos.Ponto.config.JWTUserData;
import br.com.dnos.Ponto.controller.request.UserRequest;
import br.com.dnos.Ponto.controller.response.UserResponse;
import br.com.dnos.Ponto.entity.User;

public class UserMapper {
    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static User toUser(JWTUserData jwtUserData) {
        return User.builder()
                .id(jwtUserData.id())
                .name(jwtUserData.name())
                .email(jwtUserData.email())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
