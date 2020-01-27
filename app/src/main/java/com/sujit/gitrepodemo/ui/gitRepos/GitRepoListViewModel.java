package com.sujit.gitrepodemo.ui.gitRepos;

import android.util.Log;

import com.sujit.gitrepodemo.data.models.GithubRepoEntity;
import com.sujit.gitrepodemo.data.source.DataRepository;
import com.sujit.gitrepodemo.webservice.APIService;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GitRepoListViewModel extends ViewModel {

    public final String TAG = getClass().getSimpleName();
    private MutableLiveData<List<GithubRepoEntity>> githubRepoMutableLiveData;
    DataRepository dataRepository;


    @Inject
    public GitRepoListViewModel(APIService apiService) {
        Log.e(TAG, "GitRepoListViewModel: " + apiService.hashCode());

        dataRepository = new DataRepository(apiService);
        dataRepository.getRepositories();
    }
}
