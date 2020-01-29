package com.sujit.gitrepodemo.data.local.dao;

import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface GitRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertGitRepoList(List<GitRepoEntity> githubEntities);

    @Query("SELECT * FROM GitRepoEntity where pageNumber = :pageNumber")
    List<GitRepoEntity> getGithubRepositoriesByPageNumber(Long pageNumber);
}
