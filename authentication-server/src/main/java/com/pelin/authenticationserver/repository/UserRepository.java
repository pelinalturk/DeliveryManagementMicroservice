package com.pelin.authenticationserver.repository;

import com.pelin.authenticationserver.model.Role;
import com.pelin.authenticationserver.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    Optional<User> findByIdAndRole(String userId, Role role);
}
