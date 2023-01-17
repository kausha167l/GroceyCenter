package com.rationcenter.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rationcenter.api.dto.userDtos.SignInDto;
import com.rationcenter.api.dto.userDtos.SignInResponseDto;
import com.rationcenter.api.dto.userDtos.SignUpDto;
import com.rationcenter.api.dto.userDtos.ResponseDto;
import com.rationcenter.api.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/sign_up")
    public ResponseEntity<ResponseDto> signUp(@RequestBody SignUpDto sdto){
        return ResponseEntity.ok(userService.signUp(sdto));
    }

    @PostMapping("/sign_in")
    public ResponseEntity<SignInResponseDto> signIn(@RequestBody SignInDto sidto){
        return ResponseEntity.ok(userService.signIn(sidto));
    }
}
