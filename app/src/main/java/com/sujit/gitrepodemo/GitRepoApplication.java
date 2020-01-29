package com.sujit.gitrepodemo;

import android.app.Activity;
import android.app.Application;


import com.sujit.gitrepodemo.di.component.DaggerAppComponent;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class GitRepoApplication extends Application implements HasActivityInjector, HasFragmentInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<android.app.Fragment> fragmentInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;
    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }



    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}