package com.example.project.bestseller;

import com.example.project.bestseller.BookResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("bookResult")
    @Expose
    private BookResult bookResult;

    public BookResult getBookResult() {

        return bookResult;
    }
    public void setBookResult(BookResult bookResult) {

        this.bookResult = bookResult;
    }
}
