package com.markhetherington.thisishow.models;

/**
 * Created by markhetherington on 2015-11-19.
 */
public class MaterialQuantityItem {
    int count = 0;
    Material material = new Material();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
