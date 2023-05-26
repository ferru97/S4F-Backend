package com.ferru97.s4f.user.microservice.converter;

import com.ferru97.s4f.user.microservice.model.dto.request.UserRegistrationDto;
import com.ferru97.s4f.user.microservice.model.entity.User;
import com.ferru97.s4f.user.microservice.security.SecurityUtils;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRegistrationToModelConverter implements Function<UserRegistrationDto, User> {

  private final SecurityUtils securityUtils;

  @Override
  public User apply(UserRegistrationDto userRegistrationDto) {
    return User.builder()
        .firstName(userRegistrationDto.getFirstName())
        .lastName(userRegistrationDto.getLastName())
        .nickname(userRegistrationDto.getNickname())
        .email(userRegistrationDto.getEmail())
        .password(securityUtils.encryptPassword(userRegistrationDto.getPassword()))
        .birthday(userRegistrationDto.getBirthday())
        .active(true)
        .build();
  }
}
