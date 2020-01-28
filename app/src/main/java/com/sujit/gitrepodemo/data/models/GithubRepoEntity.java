package com.sujit.gitrepodemo.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class GithubRepoEntity implements Parcelable
{
    private String tags_url;

    private String contributors_url;

    private String notifications_url;

    private String description;

    private String subscription_url;


    private String id;

    private Owner owner;

    private String archive_url;



    private String pulls_url;

    private String hooks_url;

    private String assignees_url;

    private String trees_url;

    private String node_id;

    protected GithubRepoEntity(Parcel in) {
        tags_url = in.readString();
        contributors_url = in.readString();
        notifications_url = in.readString();
        description = in.readString();
        subscription_url = in.readString();
        id = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        archive_url = in.readString();
        pulls_url = in.readString();
        hooks_url = in.readString();
        assignees_url = in.readString();
        trees_url = in.readString();
        node_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tags_url);
        dest.writeString(contributors_url);
        dest.writeString(notifications_url);
        dest.writeString(description);
        dest.writeString(subscription_url);
        dest.writeString(id);
        dest.writeParcelable(owner, flags);
        dest.writeString(archive_url);
        dest.writeString(pulls_url);
        dest.writeString(hooks_url);
        dest.writeString(assignees_url);
        dest.writeString(trees_url);
        dest.writeString(node_id);
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

    public String getTags_url ()
    {
        return tags_url;
    }

    public void setTags_url (String tags_url)
    {
        this.tags_url = tags_url;
    }

    public String getContributors_url ()
    {
        return contributors_url;
    }

    public void setContributors_url (String contributors_url)
    {
        this.contributors_url = contributors_url;
    }

    public String getNotifications_url ()
    {
        return notifications_url;
    }

    public void setNotifications_url (String notifications_url)
    {
        this.notifications_url = notifications_url;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getSubscription_url ()
    {
        return subscription_url;
    }

    public void setSubscription_url (String subscription_url)
    {
        this.subscription_url = subscription_url;
    }


}