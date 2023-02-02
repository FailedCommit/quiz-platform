package com.maatlabs.userservice.api;

import com.chargebee.cbkafkaspringbootstarter.MYDummyLibrary;
import com.maatlabs.userservice.beans.QuizUser;
import com.maatlabs.userservice.dtos.UserRegistrationRequest;
import com.maatlabs.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApi {
    private final UserService userService;
    private final MYDummyLibrary myLib;

    @GetMapping("/hi")
    public String hi() {
        return "Hi User Mohit";
    }

    @GetMapping("/")
    public String verify() {
        return myLib.message();
    }

    @PostMapping("/registration")
    public ResponseEntity<QuizUser> registerUser(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }


    @GetMapping("/{userId}")
    public ResponseEntity<QuizUser> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

}
