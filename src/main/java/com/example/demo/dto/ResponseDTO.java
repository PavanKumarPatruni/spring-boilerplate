package com.example.demo.dto;

import com.example.demo.constants.AppVersion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseDTO<T> {

    private String version = AppVersion.version;
    private boolean updateMandatory = AppVersion.updateMandatory;

    private boolean success;

    private int statusCode;

    private String message = null;

    private T data = null;

    private String debugMessage = null;

    public ResponseDTO(boolean success) {
        this.success = success;
    }

    public ResponseDTO(boolean success, HttpStatus httpStatus, String message) {
        this.success = success;
        this.statusCode = httpStatus.value();
        this.message = message;
    }

    public ResponseDTO(boolean success, HttpStatus httpStatus, String message, String debugMessage) {
        this.success = success;
        this.statusCode = httpStatus.value();
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public ResponseDTO(boolean success, HttpStatus httpStatus, String message, T data) {
        this.success = success;
        this.statusCode = httpStatus.value();
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(boolean success, HttpStatus httpStatus, String message, T data, String debugMessage) {
        this.success = success;
        this.statusCode = httpStatus.value();
        this.message = message;
        this.data = data;
        this.debugMessage = debugMessage;
    }

    public ResponseEntity<ResponseDTO<T>> formatResponse() {
        return new ResponseEntity<>(this, HttpStatus.valueOf(this.statusCode));
    }

}
