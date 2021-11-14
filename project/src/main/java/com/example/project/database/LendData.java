package com.example.project.database;

public class LendData {
    int _id;
    String imageurl;
    String title;
    String author;
    String publisher;
    String categoryName;
    String categoryId;
    String itemId;
    String link;
    String customerReviewRank;
    String description;
    String pubDate;
    String PriceSales;
    String PriceStandard;
    String SaleStatus;
    //    -- 대여된 상태라면 상세 들어갈 때 버튼이 반납하기로 되어야 함
               // 상세 아이디와 데이터베이스가 가지고 있는 아이디 비교

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCustomerReviewRank() {
        return customerReviewRank;
    }

    public void setCustomerReviewRank(String customerReviewRank) {
        this.customerReviewRank = customerReviewRank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPriceSales() {
        return PriceSales;
    }

    public void setPriceSales(String PriceSales) {
        this.PriceSales = PriceSales;
    }

    public String getPriceStandard() {
        return PriceStandard;
    }

    public void setPriceStandard(String PriceStandard) {
        this.PriceStandard  = PriceStandard ;
    }

    public String getSaleStatus() {
        return SaleStatus;
    }

    public void setSaleStatus(String SaleStatus) {
        this.SaleStatus  = SaleStatus ;
    }


}
