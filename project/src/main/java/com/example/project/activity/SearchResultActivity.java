package com.example.project.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.network.RetrofitClient;
import com.example.project.network.RetrofitInterface;
import com.example.project.search.SearchAdapter;
import com.example.project.search.SearchItem;
import com.example.project.search.SearchResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {

    private EditText searchresultText;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    private String API_KEY = "2D0B644A06377C20F59B74D85284538C88437BA528A88327AE1A37054C6CC8A0";

    private List<SearchItem> searchItem;
    private List<SearchItem> Searchresult = new ArrayList<>();

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        recyclerView = findViewById(R.id.resultrecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        searchresultText = findViewById(R.id.searchresultText);

        searchresultText.setText(getIntent().getStringExtra("query"));

        searchNetwork(getIntent().getStringExtra("query"));

        ImageView imageView = findViewById(R.id.ResearchBtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO 공백체크..... 공백이면 검색어 눌러줘..... 토스트
                if(searchresultText.getText().toString().equals(""))
                {
                    Toast t = Toast.makeText(SearchResultActivity.this, "검색할 내용을 입력하세요", Toast.LENGTH_SHORT);
                    t.show();
                }
                else
                {
                    searchNetwork(searchresultText.getText().toString());
                    /*
                    for(int i=0; i<searchItem.size(); i++)
                    {
                        if(searchItem.get(i).getTitle().contains(searchresultText.getText().toString()) || searchItem.get(i).getAuthor().contains(searchresultText.getText().toString()))
                        {
                            searchNetwork(searchresultText.getText().toString());
                        }
                        else
                        {
                            Toast toast = Toast.makeText(SearchResultActivity.this, "검색 결과가 없습니다.", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }*/
                }

            }
        });

        ImageView logoBtn = findViewById(R.id.logoBtn);
        logoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchResultActivity.this , MainActivity.class);
                startActivity(intent);

            }
        });

    }


    public void searchNetwork(String search){
        retrofitInterface.getSearch(API_KEY, search, "json").enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult result = response.body();
                searchItem = result.getSearchItem();

                //Log.d("retrofit", "Data fetch success" + result.getSearchItem().get(0).getDescription());
                mAdapter = new SearchAdapter(result.getSearchItem(), new SearchAdapter.onClickSend() {
                    @Override
                    public void onClickBody(SearchItem searchItem) {
                        Log.d("onclick2" , "item == " + searchItem.getTitle());
                        Intent intent = new Intent(SearchResultActivity.this , BookDetailActivity.class);
                        intent.putExtra("image", searchItem.getCoverLargeUrl());
                        intent.putExtra("title" , searchItem.getTitle());
                        intent.putExtra("author", searchItem.getAuthor());
                        intent.putExtra("publisher", searchItem.getPublisher());
                        intent.putExtra("pricestandard", searchItem.getPriceStandard()+"");
                        intent.putExtra("pricesales", searchItem.getPriceSales()+"");
                        intent.putExtra("salestatus", searchItem.getSaleStatus());
                        intent.putExtra("link", searchItem.getLink());
                        intent.putExtra("review", searchItem.getCustomerReviewRank());
                        intent.putExtra("itemId", searchItem.getItemId()+"");
                        intent.putExtra("categoryId", searchItem.getCategoryId()+"");
                        intent.putExtra("categoryName", searchItem.getCategoryName());
                        intent.putExtra("description", searchItem.getDescription());
                        intent.putExtra("pubDate", searchItem.getPubDate()+"");
                        intent.putExtra("customerReviewRank", searchItem.getCustomerReviewRank()+"");
                        intent.putExtra("kind" , "searchData");
                        startActivity(intent);
                    }
                });

                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.d("retrofit", t.getMessage());
            }
        });
    }

}