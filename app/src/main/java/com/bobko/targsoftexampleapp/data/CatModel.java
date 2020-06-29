package com.bobko.targsoftexampleapp.data;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class CatModel {
    @SerializedName("breeds")
    @Ignore
    private List<Object> breeds = null;
    @SerializedName("id")
    @PrimaryKey
    @NotNull
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;

    public CatModel(List<Object> breeds, String id, String url, Integer width, Integer height) {
        this.breeds = breeds;
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public CatModel(String id, String url, Integer width, Integer height) {
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public List<Object> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Object> breeds) {
        this.breeds = breeds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
