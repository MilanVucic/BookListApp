package com.vucic.booklist.models;

import java.util.List;

public interface Book {
    String getTitle();
    String getSubtitle();
    String getImageUrl();
    List<String> getAuthors();
}
