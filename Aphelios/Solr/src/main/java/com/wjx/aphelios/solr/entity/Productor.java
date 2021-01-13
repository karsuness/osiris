package com.wjx.aphelios.solr.entity;

/**
 * @author WJX
 * @since 2018/4/13 13:57
 */
public class Productor {
    /**
     * 商品名
     */
    private String name;
    /**
     * 商品价格
     */
    private Long price;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品图片
     */
    private String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Productor() {
    }

    public Productor(String name, Long price, String description, String picture) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }
}