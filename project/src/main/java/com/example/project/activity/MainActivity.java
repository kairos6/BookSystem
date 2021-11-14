package com.example.project.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.bestseller.BookAdapter;
import com.example.project.bestseller.BookResult;
import com.example.project.bestseller.Item;
import com.example.project.R;
import com.example.project.network.RetrofitClient;
import com.example.project.network.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private ImageView logoBtn;
    private ImageView searchBtn;
    private EditText searchText;


    private Button main;
    private Button myBookList;
    private CardView bookList;

    private AlertDialog alertDialog;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    private String API_KEY = "2D0B644A06377C20F59B74D85284538C88437BA528A88327AE1A37054C6CC8A0";

    private List<Item> oriItem;
    private List<Item> search = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        searchText = findViewById(R.id.searchText);
        searchBtn = findViewById(R.id.searchBtn);
        logoBtn = findViewById(R.id.logo_btn);
        myBookList = findViewById(R.id.myBookList);
        main = findViewById(R.id.main);

        bookList = findViewById(R.id.booklist);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        myBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , MyBookListActivity.class);
                startActivity(intent);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this , MainActivity.class);
                startActivity(intent3);
            }
        });


        retrofitInterface.getBook(API_KEY, 100,"json").enqueue(new Callback<BookResult>() {
            @Override
            public void onResponse(Call<BookResult> call, Response<BookResult> response) {
                BookResult result = response.body();
                oriItem = result.getItem();

//                BookResult bookResult = result.getBookResult();

                Log.d("retrofit", "Data fetch success" + result.getItem().get(0).getDescription());
                mAdapter = new BookAdapter(result.getItem(), new BookAdapter.onClickSend() {
                    @Override
                    public void onClickBody(Item item) {
                        Log.d("onclick" , "item == " + item.getTitle());
                        Intent intent = new Intent(MainActivity.this , BookDetailActivity.class);
                        intent.putExtra("title" , item.getTitle());
                        intent.putExtra("author", item.getAuthor());
                        intent.putExtra("publisher", item.getPublisher());
                        intent.putExtra("image", item.getCoverLargeUrl());
                        intent.putExtra("description", item.getDescription());
                        intent.putExtra("pricestandard", item.getPriceStandard()+"");
                        intent.putExtra("pricesales", item.getPriceSales()+"");
                        intent.putExtra("salestatus", item.getSaleStatus());
                        intent.putExtra("link", item.getLink());
                        intent.putExtra("itemId", item.getItemId()+"");
                        intent.putExtra("categoryId", item.getCategoryId()+"");
                        intent.putExtra("categoryName", item.getCategoryName());
                        intent.putExtra("pubDate", item.getPubDate()+"");
                        intent.putExtra("customerReviewRank", item.getCustomerReviewRank()+"");
                        intent.putExtra("kind" , "mainData");
                        startActivity(intent);
                    }
                });

                recyclerView.setAdapter(mAdapter);


                searchBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){


                        search.clear();

                        if (searchText.getText().toString().equals("")) {
                            Toast t = Toast.makeText(MainActivity.this, "검색할 내용을 입력하세요", Toast.LENGTH_SHORT);
                            t.show();
                        }
                        else
                        {
                            Intent intent = new Intent(MainActivity.this , SearchResultActivity.class);
                            intent.putExtra("query", searchText.getText().toString());
                            startActivity(intent);

                            /*
                            for(int i=0; i<oriItem.size(); i++)
                            {
                                if(oriItem.get(i).getTitle().contains(searchText.getText().toString()) || oriItem.get(i).getAuthor().contains(searchText.getText().toString()))
                                {
                                    Intent intent = new Intent(MainActivity.this , SearchResultActivity.class);
                                    intent.putExtra("query", searchText.getText().toString());
                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(MainActivity.this, "검색 결과가 없습니다.", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }*/
                        }
            }
        });

                logoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                /*
                logoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        search.clear();

                        mAdapter = new BookAdapter(oriItem, new BookAdapter.onClickSend() {
                            @Override
                            public void onClickBody(Item item) {
                               // Log.d("onclick" , "item == " + item.getTitle());
                               Intent intent2 = new Intent(MainActivity.this , BookDetailActivity.class);
//                                intent.putExtra("title" , item.getTitle());
//                                intent.putExtra("author", item.getAuthor());
//                                intent.putExtra("publisher", item.getPublisher());
//                                intent.putExtra("customerReviewRank", item.getCustomerReviewRank());
//                                intent.putExtra("pricestandard", item.getPriceStandard());
//                                intent.putExtra("pricesales", item.getPriceSales());
//                                intent.putExtra("salestatus", item.getSaleStatus());
//                                intent.putExtra("link", item.getLink());
//                                intent.putExtra("description", item.getDescription());
                             startActivity(intent2);

                            }
                        });
                        mAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(mAdapter);


                    }
                });
                */

    }

            @Override
            public void onFailure(Call<BookResult> call, Throwable t) {
                Log.d("retrofit", t.getMessage());
            }

        });  //*****



    }
}


