package com.sujit.gitrepodemo.ui.gitRepoDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.ui.gitRepoDetails.com.sujit.gitrepodemo.ui.gitRepoDetails.GitRepoDetailsFragment;

public class GitRepoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_repo_details_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, GitRepoDetailsFragment.newInstance())
                    .commitNow();
        }
    }
}
