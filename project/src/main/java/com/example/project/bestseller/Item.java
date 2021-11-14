package com.example.project.bestseller;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pubDate")
    @Expose
    private String pubDate;
    @SerializedName("priceStandard")
    @Expose
    private Integer priceStandard;
    @SerializedName("priceSales")
    @Expose
    private Integer priceSales;
    @SerializedName("discountRate")
    @Expose
    private int discountRate;
    @SerializedName("saleStatus")
    @Expose
    private String saleStatus;
    @SerializedName("mileage")
    @Expose
    private int mileage;
    @SerializedName("mileageRate")
    @Expose
    private int mileageRate;
    @SerializedName("coverSmallUrl")
    @Expose
    private String coverSmallUrl;
    @SerializedName("coverLargeUrl")
    @Expose
    private String coverLargeUrl;
    @SerializedName("categoryId")
    @Expose
    private int categoryId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("customerReviewRank")
    @Expose
    private float customerReviewRank;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("translator")
    @Expose
    private String translator;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("mobileLink")
    @Expose
    private String mobileLink;
    @SerializedName("additionalLink")
    @Expose
    private String additionalLink;
    @SerializedName("reviewCount")
    @Expose
    private Integer reviewCount;
    @SerializedName("rank")
    @Expose
    private Integer rank;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getPriceStandard() {
        return priceStandard;
    }

    public void setPriceStandard(Integer priceStandard) {
        this.priceStandard = priceStandard;
    }

    public Integer getPriceSales() {
        return priceSales;
    }

    public void setPriceSales(Integer priceSales) {
        this.priceSales = priceSales;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileageRate() {
        return mileageRate;
    }

    public void setMileageRate(int mileageRate) {
        this.mileageRate = mileageRate;
    }

    public String getCoverSmallUrl() {
        return coverSmallUrl;
    }

    public void setCoverSmallUrl(String coverSmallUrl) {
        this.coverSmallUrl = coverSmallUrl;
    }

    public String getCoverLargeUrl() {
        return coverLargeUrl;
    }

    public void setCoverLargeUrl(String coverLargeUrl) {
        this.coverLargeUrl = coverLargeUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getCustomerReviewRank() {
        return customerReviewRank;
    }

    public void setCustomerReviewRank(Integer customerReviewRank) {
        this.customerReviewRank = customerReviewRank;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getAdditionalLink() {
        return additionalLink;
    }

    public void setAdditionalLink(String additionalLink) {
        this.additionalLink = additionalLink;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}