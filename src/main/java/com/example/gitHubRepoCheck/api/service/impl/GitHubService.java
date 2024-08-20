package com.example.gitHubRepoCheck.api.service.impl;

import com.example.gitHubRepoCheck.api.exception.GitHubApiException;
import com.example.gitHubRepoCheck.api.model.Branch;
import com.example.gitHubRepoCheck.api.model.Repository;
import com.example.gitHubRepoCheck.api.service.IGitHubService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GitHubService implements IGitHubService {

    @Value("${github.api-url}")
    private String githubApiUrl;

    private final RestTemplate restTemplate;

    public GitHubService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Repository> getRepositories(String username) {
        try {
            String url = String.format("%s/users/%s/repos", githubApiUrl, username);
            var repositories = restTemplate.getForObject(url, Repository[].class);

            if (repositories == null || repositories.length == 0) {
                throw new GitHubApiException("No repositories found for user: " + username);
            }

            return Stream.of(repositories)
                    .filter(repo -> !repo.isFork())
                    .map(repo -> new Repository(
                            repo.getRepositoryName(),
                            repo.getOwner(),
                            false,
                            getBranches(username, repo.getRepositoryName())
                    ))
                    .collect(Collectors.toList());

        } catch (HttpClientErrorException e) {
            throw new GitHubApiException("User not found: " + username);
        }
    }


    private List<Branch> getBranches(String username, String repositoryName) {
        String url = String.format("%s/repos/%s/%s/branches", githubApiUrl, username, repositoryName);
        var branches = restTemplate.getForObject(url, Branch[].class);

        if (branches != null) {
            return Stream.of(branches)
                    .map(branch -> new Branch(branch.getName(), branch.getLastCommitSha()))
                    .collect(Collectors.toList());
        } else {
            return List.of();
        }

    }
}
