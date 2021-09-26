package com.example.project;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("https://book.interpark.com/api/bestSeller.api")
    Call<BookResult> getBook(@Query("key") String key, @Query("categoryId") int categoryId, @Query("output") String output);
    Call<SearchResult> getSearch(@Query("key") String key, @Query("query") String query, @Query("output") String output);
}
