package com.easylang.demo;

import java.util.Optional;
import java.util.Set;

import org.hibernate.type.EnumType;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;




public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Set<User> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String firstname, String lastname);
}

// File: UserRepository.java

// public interface UserRepository extends JpaRepository<User, Integer> {
//     Optional<User> findByUsername(String username);

//     Set<User> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String firstname, String lastname);
// }