package com.thmobile.cirestechnologiesproject.utils;

public class DataModel {

    //Models
    private String author;
    private String content;
    private String date;
    private String imageUrl;
    private String readMoreUrl;
    private String time;
    private String title;
    private String url;

    public DataModel(String author, String content, String date, String imageUrl, String readMoreUrl, String time, String title, String url) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
        this.time = time;
        this.title = title;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReadMoreUrl() {
        return readMoreUrl;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}