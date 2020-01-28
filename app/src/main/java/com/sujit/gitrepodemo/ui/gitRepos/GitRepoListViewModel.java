package com.sujit.gitrepodemo.ui.gitRepos;

import android.util.Log;

import com.sujit.gitrepodemo.data.models.GithubRepoEntity;
import com.sujit.gitrepodemo.data.source.DataSource;
import com.sujit.gitrepodemo.webservice.APIService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GitRepoListViewModel extends ViewModel {

    private final String TAG = getClass().getSimpleName();

    private List<GithubRepoEntity> githubRepoEntityList;
    private MutableLiveData<List<GithubRepoEntity>> githubRepoEntityLiveData;
    private DataSource dataSource;
    private Long currentPageNumber;
    private Long totalPages;

    @Inject
    public GitRepoListViewModel(APIService apiService) {
        Log.e(TAG, "GitRepoListViewModel: " + apiService.hashCode());
        githubRepoEntityList = new ArrayList<>();
        githubRepoEntityLiveData = new MutableLiveData<>();
        dataSource = new DataSource(apiService);
        currentPageNumber = 0L;
        totalPages = 0L;
    }

    public void loadGithubRepositories() {
        dataSource.getGithubRepositories(++currentPageNumber)
                .subscribe(response -> {
                    if (response.isSuccessful()) {
                        totalPages = response.body().getTotalCount();
                        githubRepoEntityList.addAll(response.body().getItems());
                        getRepositoryListLiveData().postValue(githubRepoEntityList);
                    }
                });
    }


    public List<GithubRepoEntity> getGithubRepositoriesList() {
        return githubRepoEntityList;
    }

    public MutableLiveData<List<GithubRepoEntity>> getRepositoryListLiveData() {
        return githubRepoEntityLiveData;
    }


    public boolean isLastPage() {
        return currentPageNumber >= totalPages;
    }
}
