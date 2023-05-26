package com.ferru97.s4f.user.microservice.exception.code;

import lombok.Getter;

@Getter
public enum RegistrationExceptionCode implements ExceptionCode{
  CONSTRAINT_VIOLATION("USER-REGISTRATION-01", "Constraints violation");

  private String id;

  private String description;

  RegistrationExceptionCode(String id, String description) {
    this.id = id;
    this.description = description;
  }


}
