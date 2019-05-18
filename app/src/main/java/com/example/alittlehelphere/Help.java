package com.example.alittlehelphere;

import com.squareup.moshi.Json;

public class Help {

    @Json(name = "title")
    private String title;

    @Json(name = "address")
    private String address;

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }
}
