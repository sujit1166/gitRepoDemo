package com.sujit.gitrepodemo.ui.gitRepos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sujit.gitrepodemo.R;
import javax.inject.Inject;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;

public class GitRepoListFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private GitRepoListViewModel viewModel;
    private String TAG = getClass().getName();


    public static GitRepoListFragment newInstance() {
        return new GitRepoListFragment();
    }

    public GitRepoListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.git_repo_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewModel();
        initView();
    }


    private void initView() {
        viewModel.loadGithubRepositories();
    }


    private void initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GitRepoListViewModel.class);
        viewModel.getRepositoryListLiveData().observe(this, repositoriesList -> {
            Log.e(TAG, "initialiseViewModel: " + repositoriesList.toString());
        });
    }
}
