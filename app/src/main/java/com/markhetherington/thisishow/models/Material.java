package com.markhetherington.thisishow.models;

import java.util.List;

public class Material {
    private String name;
    private String description;
    private String imageUrl;
    private List<MaterialPurchaseInfo> purchaseInfoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<MaterialPurchaseInfo> getPurchaseInfoList() {
        return purchaseInfoList;
    }

    public void setPurchaseInfoList(List<MaterialPurchaseInfo> purchaseInfoList) {
        this.purchaseInfoList = purchaseInfoList;
    }
}
