package com.sujit.gitrepodemo.ui.gitRepos;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.data.models.GithubRepoEntity;
import com.sujit.gitrepodemo.databinding.GitRepoItemBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GitRepoListAdapter extends RecyclerView.Adapter<GitRepoListAdapter.RepoViewHolder> {

    private Context context;
    private List<GithubRepoEntity> githubRepoEntityList;

    public interface OnItemClickListener {
        void onItemClickListener(GithubRepoEntity githubRepoEntity);
    }

    private OnItemClickListener onItemClickListener;

    public GitRepoListAdapter(Context context) {
        this.context = context;
        this.githubRepoEntityList = new ArrayList<>();
    }


    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        GitRepoItemBinding itemBinding = GitRepoItemBinding.inflate(layoutInflater, parent, false);
        return new RepoViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public void setItems(List<GithubRepoEntity> entities) {
        this.githubRepoEntityList.addAll(entities);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return githubRepoEntityList == null ? 0 : githubRepoEntityList.size();
    }


    public GithubRepoEntity getItem(int position) {
        return githubRepoEntityList.get(position);
    }


    protected class RepoViewHolder extends RecyclerView.ViewHolder {

        private GitRepoItemBinding binding;

        public RepoViewHolder(GitRepoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GithubRepoEntity gitRepo) {

            binding.tvRepoName.setText(gitRepo.getFullName());
            binding.tvDescription.setText(gitRepo.getDescription());
            binding.tvLanguage.setText(gitRepo.getLanguage());
            binding.tvStarsCount.setText(String.valueOf(gitRepo.getStarsCount()));
            binding.cvRepo.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(gitRepo);
                }
            });
        }
    }
}
