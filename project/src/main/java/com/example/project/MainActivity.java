package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
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


    private Button book;
    private Button myBookList;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    private String API_KEY = "C9BEB21ED4863A9B7204A9524CDBBE6560105888C40CF319882E42FE8BC9E550";

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
        book = findViewById(R.id.book);
        myBookList = findViewById(R.id.myBookList);


        retrofitInterface.getBook(API_KEY, 100,"json").enqueue(new Callback<BookResult>() {
            @Override
            public void onResponse(Call<BookResult> call, Response<BookResult> response) {
                BookResult result = response.body();
                oriItem = result.getItem();
//                BookResult bookResult = result.getBookResult();

                Log.d("retrofit", "Data fetch success" + result.getItem().get(0).getDescription());
                mAdapter = new BookAdapter(result.getItem());
                
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
                            for(int i = 0; i < oriItem.size(); i++)
                            {
                                if(oriItem.get(i).getTitle().contains(searchText.getText().toString()))
                                {
                                    /*
                                    Toast t = Toast.makeText(MainActivity.this, "포함.", Toast.LENGTH_SHORT);
                                    t.show();
                                     */

                                    Intent intent = new Intent(MainActivity.this , SearchResultActivity.class);
                                    startActivity(intent);

                                    search.add(oriItem.get(i));
                                }
                                else
                                {
                                    /*
                                    Toast t = Toast.makeText(MainActivity.this, "없음.", Toast.LENGTH_SHORT);
                                    t.show();*/
                                    Intent intent = new Intent(MainActivity.this , NoSearchResultActivity.class);
                                    startActivity(intent);
                                }

                            }
                            mAdapter = new BookAdapter(search);
                            mAdapter.notifyDataSetChanged();
                            recyclerView.setAdapter(mAdapter);
                        }
                    }
                });

                logoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        search.clear();
                        mAdapter = new BookAdapter(oriItem);
                        mAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(mAdapter);


                    }
                });
            }

            @Override
            public void onFailure(Call<BookResult> call, Throwable t) {
                Log.d("retrofit", t.getMessage());
            }
        });
    }

}