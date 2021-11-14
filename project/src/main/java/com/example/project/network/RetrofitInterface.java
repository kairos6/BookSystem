package com.example.project.network;

import com.example.project.bestseller.BookResult;
import com.example.project.search.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("https://book.interpark.com/api/bestSeller.api")
    Call<BookResult> getBook(@Query("key") String key, @Query("categoryId") int categoryId, @Query("output") String output);
    @GET("https://book.interpark.com/api/search.api")
    Call<SearchResult> getSearch(@Query("key") String key, @Query("query") String query, @Query("output") String output);
}
