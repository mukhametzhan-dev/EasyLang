// File: ProjectController.java

package com.easylang.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Endpoint to create a new project
    @PostMapping("/create")
    public ResponseEntity<?> createProject(@RequestBody Map<String, String> projectData) {
        try {
            String name = projectData.get("name");
            String description = projectData.get("description");
            LocalDate deadline = LocalDate.parse(projectData.get("deadline")); // Expecting yyyy-MM-dd format

            Project project = projectService.createProject(name, description, deadline);
            return ResponseEntity.ok(project);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint to add users to a project
    @PostMapping("/{projectId}/addUsers")
    public ResponseEntity<?> addUsersToProject(@PathVariable Integer projectId, @RequestBody Set<String> usernames) {
        try {
            Project updatedProject = projectService.addUsersToProject(projectId, usernames);
            return ResponseEntity.ok(updatedProject);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Optional: Endpoint to search users
    @GetMapping("/searchUsers")
    public ResponseEntity<?> searchUsers(@RequestParam String query) {
        try {
            Set<User> users = projectService.searchUsersByName(query);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}