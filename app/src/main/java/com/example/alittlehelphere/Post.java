package com.example.alittlehelphere;

import com.squareup.moshi.Json;

public class Post {
    @Json(name = "userId")
    private int userId;

    @Json(name = "id")
    private int id;

    @Json(name = "title")
    private String title;

    @Json(name = "body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
