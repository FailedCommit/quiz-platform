package com.maatlabs.userservice.dtos;

import com.maatlabs.userservice.beans.QuizUser;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegistrationRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String phone;

    public QuizUser createUser() {
        QuizUser user = new QuizUser();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPhone(this.phone);
        return user;
    }
}
