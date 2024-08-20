package com.example.gitHubRepoCheck.api.service;


import com.example.gitHubRepoCheck.api.model.Branch;
import com.example.gitHubRepoCheck.api.model.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGitHubService {
    public List<Repository> getRepositories(String username);
}
