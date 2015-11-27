package com.markhetherington.thisishow.models;

/**
 * Created by markhetherington on 2015-11-17.
 */
public class Instruction {
    private String title;
    private String descriptionHtmlText;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionHtmlText() {
        return descriptionHtmlText;
    }

    public void setDescriptionHtmlText(String descriptionHtmlText) {
        this.descriptionHtmlText = descriptionHtmlText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
