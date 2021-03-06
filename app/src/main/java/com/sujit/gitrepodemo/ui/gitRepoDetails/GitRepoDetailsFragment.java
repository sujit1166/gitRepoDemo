package com.sujit.gitrepodemo.ui.gitRepoDetails;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;
import com.sujit.gitrepodemo.databinding.GitRepoDetailsFragmentBinding;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.AndroidSupportInjection;

import static com.sujit.gitrepodemo.AppConstants.GITREPOENTITY_INTENT;


public class GitRepoDetailsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    GitRepoDetailsFragmentBinding fragmentBinding;
    GitRepoEntity gitRepoEntity;
    private GitRepoDetailsViewModel mViewModel;
    private String TAG = getClass().getName();

    public GitRepoDetailsFragment() {
    }

    public static GitRepoDetailsFragment newInstance(GitRepoEntity gitRepoEntity) {
        GitRepoDetailsFragment fragment = new GitRepoDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(GITREPOENTITY_INTENT, gitRepoEntity);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gitRepoEntity = getArguments().getParcelable(GITREPOENTITY_INTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.git_repo_details_fragment, container, false);
        return fragmentBinding.getRoot();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(GitRepoDetailsViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {

        Picasso.get().load(gitRepoEntity.getOwner().getAvatarUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(fragmentBinding.ivProfile);

        fragmentBinding.tvRepoName.setText(gitRepoEntity.getFullName());
        fragmentBinding.tvLanguage.setText(gitRepoEntity.getLanguage());
        fragmentBinding.tvStarsCount.setText(String.valueOf(gitRepoEntity.getStarsCount()));
        fragmentBinding.tvWatchersCount.setText(String.valueOf(gitRepoEntity.getWatchers()));
        fragmentBinding.tvForkCount.setText(String.valueOf(gitRepoEntity.getForks()));
        fragmentBinding.tvDescription.setText(String.valueOf(gitRepoEntity.getDescription()));

        fragmentBinding.btnShare.setOnClickListener(v -> {
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType("text/plain")
                    .setChooserTitle(getContext().getString(R.string.share_repo_url))
                    .setText(gitRepoEntity.getHtmlUrl())
                    .startChooser();
        });
    }
}
