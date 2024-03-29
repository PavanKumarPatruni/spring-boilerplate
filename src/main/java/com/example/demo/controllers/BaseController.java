package com.example.demo.controllers;

import com.example.demo.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {

    @GetMapping
    public ResponseEntity<ResponseDTO<Object>> healthCheck() {
        return new ResponseDTO<>(true, HttpStatus.OK, "API Running", null, "Health check").formatResponse();
    }

}