package com.example.saeko.receipeapplication.recipe;

import java.io.Serializable;

/**
 * Created by fukuisaeko on 2017-07-24.
 */

public class Recipe implements Serializable {
    private String title;
    private String description;
    private int imgId;
    private boolean isChecked;
    private String process;

    public Recipe(String title, String description, int imgId, String process) {
        this.title = title;
        this.description = description;
        this.imgId = imgId;
        this.isChecked = false;
        this.process = process;

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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
