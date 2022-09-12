package com.vucic.booklist.repository.callbacks;

import com.vucic.booklist.repository.google_models.SearchResponse;

public interface GetBooksCallback {
    void onSuccess(SearchResponse data);
    void onFailure(String message);
}
