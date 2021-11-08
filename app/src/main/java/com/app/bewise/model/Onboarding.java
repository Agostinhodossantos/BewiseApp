package com.app.bewise.model;

import android.graphics.drawable.Drawable;

public class Onboarding {
    private String title, description;
    private Drawable img;

    public Onboarding(String title, String description, Drawable img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
