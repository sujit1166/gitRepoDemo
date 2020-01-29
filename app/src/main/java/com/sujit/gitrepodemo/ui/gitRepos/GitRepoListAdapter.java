package com.sujit.gitrepodemo.ui.gitRepos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.sujit.gitrepodemo.R;
import com.sujit.gitrepodemo.Utils;
import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;
import com.sujit.gitrepodemo.databinding.GitRepoItemBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GitRepoListAdapter extends RecyclerView.Adapter<GitRepoListAdapter.RepoViewHolder> {

    private Context context;
    private List<GitRepoEntity> gitRepoEntityList;

    public interface OnItemClickListener {
        void onItemClickListener(GitRepoEntity gitRepoEntity);
    }

    private OnItemClickListener onItemClickListener;

    public GitRepoListAdapter(Context context) {
        this.context = context;
        this.gitRepoEntityList = new ArrayList<>();
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

    public void setItems(List<GitRepoEntity> entities) {
        this.gitRepoEntityList.addAll(entities);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return gitRepoEntityList == null ? 0 : gitRepoEntityList.size();
    }


    public GitRepoEntity getItem(int position) {
        return gitRepoEntityList.get(position);
    }


    protected class RepoViewHolder extends RecyclerView.ViewHolder {

        private GitRepoItemBinding binding;

        public RepoViewHolder(GitRepoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GitRepoEntity gitRepo) {

            Picasso.get().load(gitRepo.getOwner().getAvatarUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivProfile);

            binding.tvRepoName.setText(gitRepo.getFullName());
            binding.tvRepoCreatedDate.setText(Utils.getDiaplayDate(gitRepo.getCreatedAt()));
            binding.tvDescription.setText(gitRepo.getDescription());
            binding.tvLanguage.setText(gitRepo.getLanguage());
            binding.tvStarsCount.setText(String.format(context.getString(R.string.star_counter),String.valueOf(gitRepo.getStarsCount())));
            binding.cvRepo.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(gitRepo);
                }
            });
        }
    }
}
