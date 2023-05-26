package com.ferru97.s4f.user.microservice.security;

import com.ferru97.s4f.user.microservice.configuration.SecurityProperties;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityUtils {

  private final SecurityProperties securityProperties;

  public String encryptPassword(String password) {
    var strength = securityProperties.getBcryptStrength();
    var seed = securityProperties.getBcryptRandomSeed().getBytes(StandardCharsets.UTF_8);
    var encoder = new BCryptPasswordEncoder(strength, new SecureRandom(seed));
    return encoder.encode(password);
  }
}
