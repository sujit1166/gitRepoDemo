package com.sujit.gitrepodemo.ui.gitRepos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.data.models.GithubRepoEntity;
import com.sujit.gitrepodemo.databinding.GitRepoListFragmentBinding;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.android.support.AndroidSupportInjection;

public class GitRepoListFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private GitRepoListViewModel viewModel;
    private String TAG = getClass().getName();

    GitRepoListFragmentBinding fragmentBinding;
    GitRepoListAdapter gitRepoListAdapter;

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

        fragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.git_repo_list_fragment, container, false);
        return fragmentBinding.getRoot();
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
        fragmentBinding.rvGitrepo.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        gitRepoListAdapter = new GitRepoListAdapter(getActivity().getApplicationContext());
        fragmentBinding.rvGitrepo.setAdapter(gitRepoListAdapter);
        gitRepoListAdapter.setOnItemClickListener(githubRepoEntity -> {
            Log.e(TAG, "OnItemClickListener: " + githubRepoEntity);
        });
        viewModel.loadGithubRepositories();
    }


    private void initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GitRepoListViewModel.class);
        viewModel.getRepositoryListLiveData().observe(this, githubRepoEntityList -> {
            Log.e(TAG, "initialiseViewModel: " + githubRepoEntityList.toString());
            gitRepoListAdapter.setItems(githubRepoEntityList);
            gitRepoListAdapter.notifyDataSetChanged();
        });
    }
}
