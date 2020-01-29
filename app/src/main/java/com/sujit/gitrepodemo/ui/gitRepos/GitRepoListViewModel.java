package com.sujit.gitrepodemo.ui.gitRepos;

import android.util.Log;

import com.sujit.gitrepodemo.data.local.dao.GitRepoDao;
import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;
import com.sujit.gitrepodemo.data.source.DataSource;
import com.sujit.gitrepodemo.data.remote.APIService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GitRepoListViewModel extends ViewModel {

    private final String TAG = getClass().getSimpleName();

    private List<GitRepoEntity> gitRepoEntityList;
    private MutableLiveData<List<GitRepoEntity>> gitRepoEntityLiveData;
    private DataSource dataSource;
    private Long currentPageNumber;
    private Long totalPages;

    @Inject
    public GitRepoListViewModel(APIService apiService, GitRepoDao gitRepoDao) {
        Log.e(TAG, "GitRepoListViewModel: " + apiService.hashCode());
        gitRepoEntityList = new ArrayList<>();
        gitRepoEntityLiveData = new MutableLiveData<>();
        dataSource = new DataSource(apiService, gitRepoDao);
        currentPageNumber = 0L;
        totalPages = 0L;
    }

    public void loadGitRepositories() {
        Log.e(TAG, "loadGitRepositories: ");
        dataSource.getGitRepositories(++currentPageNumber)
                .subscribe(resource -> {
                    if (resource.isLoaded()) {
                        gitRepoEntityList.addAll(resource.data);
                        getGitRepoListLiveData().postValue(gitRepoEntityList);
                    }
                });
    }


    public List<GitRepoEntity> getGitRepoList() {
        return gitRepoEntityList;
    }

    public MutableLiveData<List<GitRepoEntity>> getGitRepoListLiveData() {
        return gitRepoEntityLiveData;
    }


    public boolean isLastPage() {
        GitRepoEntity gitRepoEntity = getGitRepoListLiveData().getValue() != null && !getGitRepoListLiveData().getValue().isEmpty() ? getGitRepoListLiveData().getValue().get(0) : null;

        return gitRepoEntity != null && gitRepoEntity.getTotalPages() <= currentPageNumber;
    }
}
