package com.maatlabs.userservice.repos;

import com.maatlabs.userservice.beans.QuizUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<QuizUser, Long> {
}
