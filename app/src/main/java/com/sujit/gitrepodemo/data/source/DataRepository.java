package com.sujit.gitrepodemo.data.source;


import android.util.Log;

import com.sujit.gitrepodemo.data.models.GithubRepoEntity;
import com.sujit.gitrepodemo.webservice.APIService;

import java.util.List;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Singleton
public class DataRepository {

    private APIService apiService;
    private String TAG = "DataRepository";


    public DataRepository(APIService apiService) {
        this.apiService = apiService;
        Log.e(TAG, "DataRepository: Constructor");
    }

    public void getRepositories() {
        Log.e(TAG, "getRepositories: ");
        Call<List<GithubRepoEntity>> call = apiService.getRepos();
        call.enqueue(new Callback<List<GithubRepoEntity>>() {
            @Override
            public void onResponse(Call<List<GithubRepoEntity>> call, Response<List<GithubRepoEntity>> response) {
                Log.e(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepoEntity>> call, Throwable t) {
                Log.e(TAG, "onFailure: ");
            }
        });
    }
}
