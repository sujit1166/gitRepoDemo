package com.sujit.gitrepodemo.di.module;


import com.sujit.gitrepodemo.ui.gitRepoDetails.GitRepoDetailsActivity;
import com.sujit.gitrepodemo.ui.gitRepos.GitRepoListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract GitRepoListActivity contributeGitRepoListActivity();

    @ContributesAndroidInjector()
    abstract GitRepoDetailsActivity contributeGitRepoDetailsActivity();
}