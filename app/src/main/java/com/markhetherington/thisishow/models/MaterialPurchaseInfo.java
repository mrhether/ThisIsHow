package com.markhetherington.thisishow.models;

/**
 * Created by markhetherington on 2015-11-17.
 */
public class MaterialPurchaseInfo {
    private String storeName;
    private String storeLogo;
    private String purchaseUrl;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getPurchaseUrl() {
        return purchaseUrl;
    }

    public void setPurchaseUrl(String purchaseUrl) {
        this.purchaseUrl = purchaseUrl;
    }
}
