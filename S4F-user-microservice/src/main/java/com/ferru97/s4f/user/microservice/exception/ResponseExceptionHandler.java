package com.ferru97.s4f.user.microservice.exception;

import com.ferru97.s4f.user.microservice.exception.code.ExceptionCodeResponseMapper;
import com.ferru97.s4f.user.microservice.exception.code.RegistrationExceptionCode;
import com.ferru97.s4f.user.microservice.model.dto.response.ApiResponse;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ResponseExceptionHandler {

  private static final String LOG_HEADER = "ResponseExceptionHandler";

  // 400 RESPONSE

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  protected ResponseEntity<ApiResponse> handleConflict(MethodArgumentNotValidException ex, WebRequest request) {
    var violations = ex.getBindingResult().getAllErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .toList();
    log.error("{}: constraints violation exception: {}", LOG_HEADER, violations);
    return new ResponseEntity<>(
        ExceptionCodeResponseMapper.getApiErrorResponse(RegistrationExceptionCode.CONSTRAINT_VIOLATION, violations),
        HttpStatus.BAD_REQUEST);
  }

}
