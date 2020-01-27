package com.sujit.gitrepodemo.di.component;

import android.app.Application;

import com.sujit.gitrepodemo.MyGitHubApplication;
import com.sujit.gitrepodemo.di.module.ActivityModule;
import com.sujit.gitrepodemo.di.module.ApiModule;
import com.sujit.gitrepodemo.di.module.FragmentModule;
import com.sujit.gitrepodemo.di.module.ViewModelModule;
import com.sujit.gitrepodemo.webservice.APIService;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {
        ApiModule.class,
        ViewModelModule.class,
        FragmentModule.class,
        ActivityModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(MyGitHubApplication myGitHubApplication);
}
