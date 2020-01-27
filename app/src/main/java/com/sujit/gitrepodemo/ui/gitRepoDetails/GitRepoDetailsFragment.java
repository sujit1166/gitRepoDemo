package com.sujit.gitrepodemo.ui.gitRepoDetails;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sujit.gitrepodemo.R;

import javax.inject.Inject;


public class GitRepoDetailsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private GitRepoDetailsViewModel mViewModel;


    public GitRepoDetailsFragment() {
    }

    public static GitRepoDetailsFragment newInstance() {
        return new GitRepoDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.git_repo_details_fragment, container, false);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(GitRepoDetailsViewModel.class);
    }
}
