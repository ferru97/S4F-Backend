package com.ferru97.s4f.user.microservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class ApiResponse {

  public enum ResponseStatus {
    OK, WARNING, ERROR
  }

  ResponseStatus responseStatus;

  String id;

  String description;

  Object content;

}
