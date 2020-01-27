package com.sujit.gitrepodemo.di.module;

import com.sujit.gitrepodemo.di.GitRepoViewModelFactory;
import com.sujit.gitrepodemo.ui.gitRepoDetails.GitRepoDetailsViewModel;
import com.sujit.gitrepodemo.ui.gitRepos.GitRepoListViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(GitRepoViewModelFactory gitRepoViewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(GitRepoListViewModel.class)
    protected abstract ViewModel bindGitRepoListViewModel(GitRepoListViewModel gitRepoListViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(GitRepoDetailsViewModel.class)
    protected abstract ViewModel bindGitRepoDetailsViewModel(GitRepoDetailsViewModel gitRepoDetailsViewModel);
}