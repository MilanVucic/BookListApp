package com.vucic.booklist.repository.google_models;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {
    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private int totalItems;
//    @SerializedName("items")
//    private int List<Item>;

    public int getTotalItems() {
        return totalItems;
    }
}
