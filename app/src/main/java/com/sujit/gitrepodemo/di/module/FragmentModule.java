package com.sujit.gitrepodemo.di.module;

import com.sujit.gitrepodemo.ui.gitRepoDetails.GitRepoDetailsFragment;
import com.sujit.gitrepodemo.ui.gitRepos.GitRepoListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract GitRepoListFragment bindGitRepoListFragment();

    @ContributesAndroidInjector
    abstract GitRepoDetailsFragment bindGitRepoDetailsFragment();
}
