package com.ferru97.s4f.user.microservice.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

@Data
public class UserRegistrationDto {

  @NotNull(message = "First name must be provided")
  @NotBlank(message = "First name must not be blank")
  @Size(min = 2 , max = 100, message = "First name size must be between 2 and 100 ")
  @Schema(example = "Jhon")
  private String firstName;

  @NotNull(message = "Last name must be provided")
  @NotBlank(message = "Last name must not be blank")
  @Size(min = 2 , max = 100, message = "Last name size must be between 2 and 100 ")
  @Schema(example = "Doe")
  private String lastName;

  @NotNull(message = "Nickname name must be provided")
  @NotBlank(message = "Nickname must not be blank")
  @Size(min = 4 , max = 50, message = "Nickname size must be between 4 and 50 ")
  @Schema(example = "jhon97")
  private String nickname;

  @NotNull(message = "Email must be provided")
  @Email(message = "Must provide a well-formed email address")
  @Schema(example = "email@example.it")
  private String email;

  @NotNull(message = "Password name must be provided")
  @NotBlank(message = "Password must not be blank")
  @Size(min = 8 , max = 32, message = "Password size must be between 4 and 32 ")
  @Schema(example = "dasj%%dsa12")
  private String password;

  @NotNull
  private Date birthday;

  @Override
  public String toString() {
    return "UserRegistrationDto{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", nickname='" + nickname + '\'' +
        ", email='" + email + '\'' +
        ", password=********'" +
        ", birthday=" + birthday +
        '}';
  }
}
