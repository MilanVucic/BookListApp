package com.vucic.booklist.repository.google_models;

import com.google.gson.annotations.SerializedName;

public class ImageLink {
    @SerializedName("smallThumbnail")
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }
}
