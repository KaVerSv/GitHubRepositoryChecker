package com.example.gitHubRepoCheck.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GitHubApiException extends RuntimeException {
    public GitHubApiException(String message) {
        super(message);
    }
}


