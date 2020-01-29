package com.sujit.gitrepodemo.di.module;

import android.app.Application;

import com.sujit.gitrepodemo.data.local.AppDatabase;
import com.sujit.gitrepodemo.data.local.dao.GitRepoDao;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "GitRepo.db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    GitRepoDao provideGitRepoDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.gitRepoDao();
    }
}
