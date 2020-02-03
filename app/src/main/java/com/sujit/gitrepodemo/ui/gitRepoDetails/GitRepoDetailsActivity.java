package com.sujit.gitrepodemo.ui.gitRepoDetails;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import android.os.Bundle;

import com.sujit.gitrepodemo.AppConstants;
import com.sujit.gitrepodemo.R;

public class GitRepoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_repo_details_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, GitRepoDetailsFragment.newInstance(getIntent().getParcelableExtra(AppConstants.GITREPOENTITY_INTENT)))
                    .commitNow();
        }
    }

}
