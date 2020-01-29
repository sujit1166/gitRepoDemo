package com.sujit.gitrepodemo.data.source;


import android.util.Log;

import com.sujit.gitrepodemo.data.NetworkBoundResource;
import com.sujit.gitrepodemo.data.Resource;
import com.sujit.gitrepodemo.data.local.dao.GitRepoDao;
import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;
import com.sujit.gitrepodemo.data.models.GitRepoResponse;
import com.sujit.gitrepodemo.data.remote.APIService;

import java.util.List;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


@Singleton
public class DataSource {

    private APIService apiService;
    private GitRepoDao gitRepoDao;
    private String TAG = getClass().getName();


    public DataSource(APIService apiService, GitRepoDao gitRepoDao) {
        this.apiService = apiService;
        this.gitRepoDao = gitRepoDao;
    }

    public Observable<Resource<List<GitRepoEntity>>> getGitRepositories(Long pageNumber) {
        Log.e(TAG, "getGitRepositories: " );
        return new NetworkBoundResource<List<GitRepoEntity>, GitRepoResponse>() {

            @Override
            protected void saveCallResult(@NonNull GitRepoResponse response) {
                Log.e(TAG, "saveCallResult: ");
                List<GitRepoEntity> repositories = response.getItems();
                for (GitRepoEntity githubEntity : repositories) {
                    githubEntity.setPageNumber(pageNumber);
                    githubEntity.setTotalPages(response.getTotalCount());
                }
                gitRepoDao.insertGitRepoList(repositories);
            }

            @Override
            protected boolean shouldFetch() {
                Log.e(TAG, "shouldFetch: ");
                return  true;
            }

            @NonNull
            @Override
            protected Flowable<List<GitRepoEntity>> loadFromDb() {
                Log.e(TAG, "loadFromDb: " );
                List<GitRepoEntity> repositories = gitRepoDao.getGithubRepositoriesByPageNumber(pageNumber);
                return (repositories == null || repositories.isEmpty()) ?
                        Flowable.empty() : Flowable.just(repositories);
            }

            @NonNull
            @Override
            protected Observable<Resource<GitRepoResponse>> createCall() {
                Log.e(TAG, "createCall: ");
                return apiService.getGithubRepositories("android", "stars", 30L, pageNumber)
                        .flatMap(response ->
                                Observable.just(response.isSuccessful()
                                        ? Resource.success(response.body())
                                        : Resource.error("", new GitRepoResponse())));
            }

        }.getAsObservable();
    }
}
