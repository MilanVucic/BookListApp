package com.vucic.booklist.repository.google_models;

import com.google.gson.annotations.SerializedName;
import com.vucic.booklist.models.Book;

import java.util.List;

public class BookModel implements Book {
    @SerializedName("id")
    private String id;
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    @Override
    public String getTitle() {
        return volumeInfo.getTitle();
    }

    @Override
    public String getSubtitle() {
        return volumeInfo.getSubtitle();
    }

    @Override
    public List<String> getAuthors() {
        return volumeInfo.getAuthors();
    }

    @Override
    public String getImageUrl() {
        if (volumeInfo == null || volumeInfo.getImageLink() == null) {
            return null;
        }
        return volumeInfo.getImageLink().getThumbnail();
    }
}
