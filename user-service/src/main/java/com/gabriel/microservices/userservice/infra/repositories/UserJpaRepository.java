package com.gabriel.microservices.userservice.infra.repositories;

import com.gabriel.microservices.userservice.presentation.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserModel, Long> {

    boolean existsUserModelByEmail(String email);
    Optional<UserModel> findByEmail(String email);
}
