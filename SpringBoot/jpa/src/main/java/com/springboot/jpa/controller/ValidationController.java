package com.springboot.jpa.controller;

import com.springboot.jpa.data.dto.ValidRequestDto;
import com.springboot.jpa.data.dto.ValidatedRequestDto;
import com.springboot.jpa.data.group.ValidationGroup1;
import com.springboot.jpa.data.group.ValidationGroup2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
@Slf4j
public class ValidationController {

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(@Valid @RequestBody ValidRequestDto validRequestDto) {
        log.info(validRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
    }

    @PostMapping("/validated/group1")
    public ResponseEntity<String> checkValidation1(@Validated(ValidationGroup1.class) @RequestBody ValidatedRequestDto validatedRequestDto) {
        log.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("validated/group2")
    public ResponseEntity<String> checkValidation2(@Validated(ValidationGroup2.class) @RequestBody ValidatedRequestDto validatedRequestDto) {
        log.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("validated/all-group")
    public ResponseEntity<String> checkValidation3(@Validated({ValidationGroup1.class, ValidationGroup2.class}) @RequestBody ValidatedRequestDto validatedRequestDto) {
        log.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

}
