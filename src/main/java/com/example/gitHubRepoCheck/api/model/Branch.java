package com.example.gitHubRepoCheck.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    private String name;
    private String lastCommitSha;
}
