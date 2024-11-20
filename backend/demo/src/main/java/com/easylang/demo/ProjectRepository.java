// File: ProjectRepository.java

package com.easylang.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // Additional query methods if needed
}