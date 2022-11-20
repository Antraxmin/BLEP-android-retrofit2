package com.example.BLEP_android_server;

import com.google.gson.annotations.SerializedName;

public class Post {
    /**
     * {
     *     "userId": 1,
     *     "id": 1,
     *     "title": "sunt aut facere repellat ~~~",
     *     "body": "quia et suscipit\nsuscipit ~~~"
     * },
     */

    private String id;
    private String code;
    private String heart;
    @SerializedName("body")
    private String bp;
    private String date;

    public Post(String id, String code, String heart, String bp, String date) {
        this.id = id;
        this.code = code;
        this.heart = heart;
        this.bp = bp;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getHeart() {
        return heart;
    }

    public String getBp() {
        return bp;
    }
    public String getDate() {
        return date;
    }
}
