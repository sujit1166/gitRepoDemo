package com.sujit.gitrepodemo.ui.gitRepos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.ui.gitRepos.ui.gitrepolist.GitRepoListFragment;

public class GitRepoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_repo_list_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, GitRepoListFragment.newInstance())
                    .commitNow();
        }
    }
}
