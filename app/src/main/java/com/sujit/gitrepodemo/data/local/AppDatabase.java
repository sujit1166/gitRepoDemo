package com.sujit.gitrepodemo.data.local;

import com.sujit.gitrepodemo.data.local.converter.TimestampConverter;
import com.sujit.gitrepodemo.data.local.dao.GitRepoDao;
import com.sujit.gitrepodemo.data.local.entity.GitRepoEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {GitRepoEntity.class}, version = 1,  exportSchema = false)
@TypeConverters({TimestampConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract GitRepoDao gitRepoDao();
}
