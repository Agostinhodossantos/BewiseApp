package com.app.bewise.model;

public class BookCategory extends Category {
    private String title;
    private int img;

    public BookCategory(int grade, int idCategory, String title, int img) {
        super(grade, idCategory);
        this.title = title;
        this.img = img;
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
