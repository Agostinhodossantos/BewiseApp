package com.app.bewise.model;

public class BookCategory {
    private String id, title;
    private int img;

    public BookCategory(String id, String title, int img) {
        this.id = id;
        this.title = title;
        this.img = img;
    }

    public BookCategory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
