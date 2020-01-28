package com.sujit.gitrepodemo.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubRepoEntity implements Parcelable {

    private Long id;

    private Long page;

    private Long totalPages;

    private String name;

    @SerializedName("full_name")
    private String fullName;

    private Owner owner;

    @SerializedName("html_url")
    private String htmlUrl;

    private String description;

    @SerializedName("contributors_url")
    private String contributorsUrl;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("stargazers_count")
    private Long starsCount;

    private Long watchers;
    private Long forks;
    private String language;
    private String score;


    protected GithubRepoEntity(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            page = null;
        } else {
            page = in.readLong();
        }
        if (in.readByte() == 0) {
            totalPages = null;
        } else {
            totalPages = in.readLong();
        }
        name = in.readString();
        fullName = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        htmlUrl = in.readString();
        description = in.readString();
        contributorsUrl = in.readString();
        createdAt = in.readString();
        if (in.readByte() == 0) {
            starsCount = null;
        } else {
            starsCount = in.readLong();
        }
        if (in.readByte() == 0) {
            watchers = null;
        } else {
            watchers = in.readLong();
        }
        if (in.readByte() == 0) {
            forks = null;
        } else {
            forks = in.readLong();
        }
        language = in.readString();
        score = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        if (page == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(page);
        }
        if (totalPages == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(totalPages);
        }
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeParcelable(owner, flags);
        dest.writeString(htmlUrl);
        dest.writeString(description);
        dest.writeString(contributorsUrl);
        dest.writeString(createdAt);
        if (starsCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(starsCount);
        }
        if (watchers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(watchers);
        }
        if (forks == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(forks);
        }
        dest.writeString(language);
        dest.writeString(score);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GithubRepoEntity> CREATOR = new Creator<GithubRepoEntity>() {
        @Override
        public GithubRepoEntity createFromParcel(Parcel in) {
            return new GithubRepoEntity(in);
        }

        @Override
        public GithubRepoEntity[] newArray(int size) {
            return new GithubRepoEntity[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(Long starsCount) {
        this.starsCount = starsCount;
    }

    public Long getWatchers() {
        return watchers;
    }

    public void setWatchers(Long watchers) {
        this.watchers = watchers;
    }

    public Long getForks() {
        return forks;
    }

    public void setForks(Long forks) {
        this.forks = forks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static Creator<GithubRepoEntity> getCREATOR() {
        return CREATOR;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}