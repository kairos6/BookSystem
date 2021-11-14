package com.example.project.search;

import com.example.project.search.SearchResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("SearchResult")
    @Expose
    private SearchResult searchResult;

    public SearchResult getSearchResult() {

        return searchResult;
    }
    public void setSearchResult(SearchResult searchResult) {

        this.searchResult = searchResult;
    }
}