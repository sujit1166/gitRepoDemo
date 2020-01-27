package com.sujit.gitrepodemo.webservice;


import com.sujit.gitrepodemo.data.models.GithubRepoEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  APIService {
    @GET("repositories")
    Call<List<GithubRepoEntity>> getRepos();
}
