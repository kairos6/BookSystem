package com.example.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchItem {

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
    private String discountRate;
    @SerializedName("saleStatus")
    @Expose
    private String saleStatus;
    @SerializedName("mileage")
    @Expose
    private String mileage;
    @SerializedName("mileageRate")
    @Expose
    private String mileageRate;
    @SerializedName("coverSmallUrl")
    @Expose
    private String coverSmallUrl;
    @SerializedName("coverLargeUrl")
    @Expose
    private String coverLargeUrl;
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("customerReviewRank")
    @Expose
    private Double customerReviewRank;
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

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getMileageRate() {
        return mileageRate;
    }

    public void setMileageRate(String mileageRate) {
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getCustomerReviewRank() {
        return customerReviewRank;
    }

    public void setCustomerReviewRank(Double customerReviewRank) {
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

}