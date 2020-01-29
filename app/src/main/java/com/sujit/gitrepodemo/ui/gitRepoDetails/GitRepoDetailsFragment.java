package com.sujit.gitrepodemo.ui.gitRepoDetails;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sujit.gitrepodemo.AppConstants;
import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;

import javax.inject.Inject;

import static com.sujit.gitrepodemo.AppConstants.GITREPOENTITY_INTENT;


public class GitRepoDetailsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private GitRepoDetailsViewModel mViewModel;

    GitRepoEntity gitRepoEntity;
    private String TAG = getClass().getName();

    public GitRepoDetailsFragment() {
    }

    public static GitRepoDetailsFragment newInstance(GitRepoEntity gitRepoEntity) {
        GitRepoDetailsFragment fragment = new GitRepoDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(GITREPOENTITY_INTENT, gitRepoEntity);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gitRepoEntity = getArguments().getParcelable(GITREPOENTITY_INTENT);
        }
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
