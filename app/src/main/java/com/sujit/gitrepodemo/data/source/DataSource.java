package com.sujit.gitrepodemo.data.source;


import android.util.Log;

import com.sujit.gitrepodemo.data.models.GitRepoResponse;
import com.sujit.gitrepodemo.data.models.GithubRepoEntity;
import com.sujit.gitrepodemo.webservice.APIService;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Singleton
public class DataSource {

    private APIService apiService;
    private String TAG = "DataSource";


    public DataSource(APIService apiService) {
        this.apiService = apiService;
        Log.e(TAG, "DataSource: Constructor");
    }

    public Observable<List<GithubRepoEntity>> getGithubRepositories() {
        return apiService.getGithubRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation());
    }
}
