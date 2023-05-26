package com.ferru97.s4f.user.microservice.service;

import com.ferru97.s4f.user.microservice.converter.UserRegistrationToModelConverter;
import com.ferru97.s4f.user.microservice.model.dto.request.UserRegistrationDto;
import com.ferru97.s4f.user.microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

  private static final String LOG_HEADER = "UserService";

  private final UserRepository userRepository;
  private final UserRegistrationToModelConverter userRegistrationToModelConverter;

  public void userRegistration(UserRegistrationDto userRegistrationDto) {
    log.info("{}: new user registration: {}", LOG_HEADER, userRegistrationDto);
    var newUser = userRegistrationToModelConverter.apply(userRegistrationDto);

    var newUserDb = userRepository.save(newUser);
    log.info("{}: new user successfully registered ID:{}", LOG_HEADER, newUserDb.getId());
  }
}
