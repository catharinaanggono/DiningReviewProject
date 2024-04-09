package com.example.DiningReviewProject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.DiningReviewProject.model.Users;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long>{
    Optional<Users> findUsersByUsername(String username);
}