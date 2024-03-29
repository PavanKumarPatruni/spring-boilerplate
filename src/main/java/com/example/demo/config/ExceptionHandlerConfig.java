package com.example.demo.config;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ConflictException;
import com.example.demo.exceptions.InternalServerErrorException;
import com.example.demo.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<Object>> handleException(Exception exception) {
        log.info(exception.getMessage());
        exception.printStackTrace();
        return new ResponseDTO<>(false, HttpStatus.INTERNAL_SERVER_ERROR, "Unable to process the request", exception.getMessage()).formatResponse();
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ResponseDTO<Object>> handleInternalServerException(InternalServerErrorException exception) {
        log.info(exception.getMessage());
        exception.printStackTrace();
        return new ResponseDTO<>(false, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()).formatResponse();
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDTO<Object>> handleBadRequestException(BadRequestException exception) {
        log.info(exception.getMessage());
        exception.printStackTrace();
        return new ResponseDTO<>(false, HttpStatus.BAD_REQUEST, exception.getMessage()).formatResponse();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO<Object>> handleNotFoundException(NotFoundException exception) {
        log.info(exception.getMessage());
        exception.printStackTrace();
        return new ResponseDTO<>(false, HttpStatus.NOT_FOUND, exception.getMessage()).formatResponse();
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ResponseDTO<Object>> handleConflictException(ConflictException exception) {
        log.info(exception.getMessage());
        exception.printStackTrace();
        return new ResponseDTO<>(false, HttpStatus.CONFLICT, exception.getMessage()).formatResponse();
    }

}
