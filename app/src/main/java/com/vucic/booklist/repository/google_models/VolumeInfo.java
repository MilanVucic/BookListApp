package com.vucic.booklist.repository.google_models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeInfo {
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("authors")
    private List<String> authors;
    @SerializedName("imageLinks")
    private ImageLink imageLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public ImageLink getImageLink() {
        return imageLink;
    }
}
