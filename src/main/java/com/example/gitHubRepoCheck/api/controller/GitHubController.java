
package com.example.gitHubRepoCheck.api.controller;

import com.example.gitHubRepoCheck.api.model.Repository;
import com.example.gitHubRepoCheck.api.service.impl.GitHubService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/repositories")
    public ResponseEntity<List<Repository>> getRepositories(
            @RequestParam String username,
            @RequestHeader(value = "Accept", required = false, defaultValue = "application/json") String acceptHeader) {

        List<Repository> repositories = gitHubService.getRepositories(username);
        return ResponseEntity.ok(repositories);
    }
}
