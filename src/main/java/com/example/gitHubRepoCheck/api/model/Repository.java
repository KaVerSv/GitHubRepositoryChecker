package com.example.gitHubRepoCheck.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Repository {

    @JsonProperty("name")
    private String repositoryName;

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("fork")
    private boolean isFork;

    private List<Branch> branches;

    public String getOwnerLogin() {
        if (owner == null) {
            return null;
        }
        return owner.getLogin();
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Owner {
        @JsonProperty("login")
        private String login;
    }
}
