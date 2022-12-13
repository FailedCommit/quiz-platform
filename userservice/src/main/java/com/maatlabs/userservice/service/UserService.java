package com.maatlabs.userservice.service;

import com.maatlabs.userservice.beans.QuizUser;
import com.maatlabs.userservice.dtos.UserRegistrationRequest;
import com.maatlabs.userservice.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public QuizUser registerUser(UserRegistrationRequest request) {
        return userRepo.save(request.createUser());
    }

    public QuizUser getUserById(Long userId) {
        Optional<QuizUser> userOption = userRepo.findById(userId);
        if(userOption.isPresent()) {
            return userOption.get();
        }
        throw new RuntimeException("User Not Found"); // TODO: Maybe a better way to tell UI to handle this?
    }
}
