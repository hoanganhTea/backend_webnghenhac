package com.example.webnghenhac.repository;

import com.example.webnghenhac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String username);
    boolean existsById(String id);
    Optional<User> findByUsername(String username);
}
