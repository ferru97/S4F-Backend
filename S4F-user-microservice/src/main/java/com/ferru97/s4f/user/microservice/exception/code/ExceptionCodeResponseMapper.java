package com.ferru97.s4f.user.microservice.exception.code;

import com.ferru97.s4f.user.microservice.exception.code.ExceptionCode;
import com.ferru97.s4f.user.microservice.model.dto.response.ApiResponse;
import com.ferru97.s4f.user.microservice.model.dto.response.ApiResponse.ResponseStatus;

public class ExceptionCodeResponseMapper {

  public static ApiResponse getApiErrorResponse(ExceptionCode exceptionCode, Object content) {
    return ApiResponse.builder()
        .responseStatus(ResponseStatus.ERROR)
        .id(exceptionCode.getId())
        .description(exceptionCode.getDescription())
        .content(content)
        .build();
  }

}
