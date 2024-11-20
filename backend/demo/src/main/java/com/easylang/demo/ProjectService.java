// File: ProjectService.java

package com.easylang.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public Project createProject(String name, String description, LocalDate deadline) {
        Project project = new Project(name, description, deadline);
        
        return projectRepository.save(project);
    }

    public Project addUsersToProject(Integer projectId, Set<String> usernames) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        for (String username : usernames) {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found: " + username));
            project.addUser(user);
        }

        return projectRepository.save(project);
    }
    // File: ProjectService.java

public Set<User> searchUsersByName(String query) {
    // Assuming UserRepository has a method to search by first or last name containing the query
    return new HashSet<>(userRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(query, query));
}

    // Additional methods if needed
}