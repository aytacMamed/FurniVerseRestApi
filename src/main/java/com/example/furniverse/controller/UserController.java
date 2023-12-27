package com.example.furniverse.controller;

import com.example.furniverse.dto.RegisterRequest;
import com.example.furniverse.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request){
        userService.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid RegisterRequest request) {
        return userService.login(request);
    }


}
