package com.sujit.gitrepodemo.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GitRepoResponse<T> implements Parcelable {

    @SerializedName("total_count")
    private Long totalCount;

    @SerializedName("incomplete_results")
    private Boolean incomplete_results;

    private List<GithubRepoEntity> items;

    public GitRepoResponse() {
        this.items = new ArrayList<>();
    }

    protected GitRepoResponse(Parcel in) {
        if (in.readByte() == 0) {
            totalCount = null;
        } else {
            totalCount = in.readLong();
        }
        byte tmpIncomplete_results = in.readByte();
        incomplete_results = tmpIncomplete_results == 0 ? null : tmpIncomplete_results == 1;
        items = in.createTypedArrayList(GithubRepoEntity.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (totalCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(totalCount);
        }
        dest.writeByte((byte) (incomplete_results == null ? 0 : incomplete_results ? 1 : 2));
        dest.writeTypedList(items);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GitRepoResponse> CREATOR = new Creator<GitRepoResponse>() {
        @Override
        public GitRepoResponse createFromParcel(Parcel in) {
            return new GitRepoResponse(in);
        }

        @Override
        public GitRepoResponse[] newArray(int size) {
            return new GitRepoResponse[size];
        }
    };


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<GithubRepoEntity> getItems() {
        return items;
    }

    public void setItems(List<GithubRepoEntity> items) {
        this.items = items;
    }

    public static Creator<GitRepoResponse> getCREATOR() {
        return CREATOR;
    }
}