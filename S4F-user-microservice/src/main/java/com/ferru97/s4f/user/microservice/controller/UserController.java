package com.ferru97.s4f.user.microservice.controller;

import com.ferru97.s4f.user.microservice.model.dto.request.UserRegistrationDto;
import com.ferru97.s4f.user.microservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "User controller", description = "User controller")
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

  private final UserService userService;

  @Operation(description = "Test")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "OK")
  })
  @GetMapping("/test")
  private String testPrivate() {
    return "OK";
  }

  @Operation(description = "User Registration")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "User successfully registered"),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  @PostMapping("/sign-up")
  private ResponseEntity<Object> testPrivate(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
    userService.userRegistration(userRegistrationDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
