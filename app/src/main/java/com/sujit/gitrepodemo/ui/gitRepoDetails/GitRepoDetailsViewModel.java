package com.sujit.gitrepodemo.ui.gitRepoDetails;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class GitRepoDetailsViewModel extends ViewModel {
    public final String TAG=getClass().getSimpleName();
    // TODO: Implement the ViewModel


    @Inject
    public GitRepoDetailsViewModel() {
        Log.e(TAG, "GitRepoDetailsViewModel: ");
    }
}
