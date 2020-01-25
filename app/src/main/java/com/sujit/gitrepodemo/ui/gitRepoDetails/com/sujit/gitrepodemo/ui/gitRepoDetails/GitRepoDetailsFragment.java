package com.sujit.gitrepodemo.ui.gitRepoDetails.com.sujit.gitrepodemo.ui.gitRepoDetails;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sujit.gitrepodemo.R;


public class GitRepoDetailsFragment extends Fragment {

    private GitRepoDetailsViewModel mViewModel;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GitRepoDetailsViewModel.class);
        // TODO: Use the ViewModel
    }
}
