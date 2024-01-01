package com.springboot.jpa.service;

import com.springboot.jpa.data.dto.SignInResultDto;
import com.springboot.jpa.data.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}
