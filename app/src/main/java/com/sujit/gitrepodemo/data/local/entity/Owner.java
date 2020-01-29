package com.sujit.gitrepodemo.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Owner implements Parcelable {


    @SerializedName("login")
    public String login;

    @ColumnInfo(name = "owner_id")
    @SerializedName("id")
    public Long id;

    @SerializedName("node_id")
    public String nodeId;

    @SerializedName("avatar_url")
    public String avatarUrl;

    @SerializedName("gravatar_id")
    public String gravatarId;

    @SerializedName("url")
    public String url;

    @SerializedName("repos_url")
    public String reposUrl;

    @SerializedName("type")
    public String type;

    @SerializedName("site_admin")
    public Boolean siteAdmin;

    protected Owner(Parcel in) {
        login = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        nodeId = in.readString();
        avatarUrl = in.readString();
        gravatarId = in.readString();
        url = in.readString();
        reposUrl = in.readString();
        type = in.readString();
        byte tmpSiteAdmin = in.readByte();
        siteAdmin = tmpSiteAdmin == 0 ? null : tmpSiteAdmin == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(nodeId);
        dest.writeString(avatarUrl);
        dest.writeString(gravatarId);
        dest.writeString(url);
        dest.writeString(reposUrl);
        dest.writeString(type);
        dest.writeByte((byte) (siteAdmin == null ? 0 : siteAdmin ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public static Creator<Owner> getCREATOR() {
        return CREATOR;
    }

    public Owner() {
    }
}