package com.example.saeko.receipeapplication;

/**
 * Created by fukuisaeko on 2017-07-24.
 */

public class Recipe {
    private String title;
    private String description;
    private int imgId;
    private boolean isChecked;

    public Recipe(String title, String description, int imgId) {
        this.title = title;
        this.description = description;
        this.imgId = imgId;
        this.isChecked = false;
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

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
