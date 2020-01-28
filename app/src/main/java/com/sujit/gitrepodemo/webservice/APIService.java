package com.sujit.gitrepodemo.webservice;


import com.sujit.gitrepodemo.data.models.GitRepoResponse;
import com.sujit.gitrepodemo.data.models.GithubRepoEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("search/repositories")
    Observable<Response<GitRepoResponse>> getGithubRepositories(@Query("q") String querySource,
                                                                @Query("sort") String sortBy,
                                                                @Query("per_page") Long page,
                                                                @Query("page") Long pageNumber); // q:android, sort:stars, per_page:30..
}
