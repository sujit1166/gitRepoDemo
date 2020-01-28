package com.sujit.gitrepodemo.webservice;


import com.sujit.gitrepodemo.data.models.GithubRepoEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("repositories")
    Observable<List<GithubRepoEntity>> getGithubRepositories();
}
