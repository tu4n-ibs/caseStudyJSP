package com.example.casestudy.model;

public class Products {
    private int id;
    private String name;
    private String descri;
    private String price;
    private String img;

    public Products(int id, String name, String describe, String price, String img) {
        this.id = id;
        this.name = name;
        this.descri = describe;
        this.price = price;
        this.img = img;
    }

    public Products(String name, String describe, String price, String img) {
        this.name = name;
        this.descri = describe;
        this.price = price;
        this.img = img;
    }

    public Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return descri;
    }

    public void setDescribe(String describe) {
        this.descri = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
