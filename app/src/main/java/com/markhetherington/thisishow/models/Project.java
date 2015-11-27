package com.markhetherington.thisishow.models;

import java.util.List;

public class Project {

    private String title;
    private String description;
    private String imageUrl;
    private User creator;
    private List<MaterialQuantityItem> materials;
    private List<Instruction> instructions;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<MaterialQuantityItem> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MaterialQuantityItem> materials) {
        this.materials = materials;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

}
