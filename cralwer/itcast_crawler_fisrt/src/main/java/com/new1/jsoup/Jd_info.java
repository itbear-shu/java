package com.new1.jsoup;

public class Jd_info {
    private String price;
    private String imgUrl;
    private String title;

    public Jd_info() {
    }

    public Jd_info(String price, String imgUrl, String title) {
        this.price = price;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void showInfo() {
        System.out.println(this.title);
        System.out.println(this.price);
        System.out.println(this.imgUrl);
        System.out.println("---------------------------------------------");
    }
}
