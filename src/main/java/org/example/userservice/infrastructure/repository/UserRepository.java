package org.example.userservice.infrastructure.repository;

import org.example.userservice.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
