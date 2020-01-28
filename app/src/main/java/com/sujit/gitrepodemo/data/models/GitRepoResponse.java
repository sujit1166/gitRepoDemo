package com.sujit.gitrepodemo.data.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GitRepoResponse<T> {

    @NonNull
    public boolean status;
    @Nullable
    public T data;


    public boolean isStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }
}