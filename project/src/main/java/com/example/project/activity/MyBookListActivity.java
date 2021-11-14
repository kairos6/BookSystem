package com.example.project.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.project.R;
import com.example.project.database.DBHelper;
import com.example.project.database.DataAdapter;
import com.example.project.database.LendData;

import java.util.ArrayList;

public class MyBookListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;

    private ImageView myListHomeBtn;
    private ImageView myListBack;


    ArrayList<LendData> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book_list);

        recyclerView = findViewById(R.id.resultrecyclerView);
        myListHomeBtn = findViewById(R.id.myListHome);
        myListBack = findViewById(R.id.myListBack);

        //데이터를 읽어오는데 arraylist..........
        // 2. 저장한걸 로그로....
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select _id ,imageurl, title, author, publisher, categoryId, categoryName, itemId, link, customerReviewRank, description, pubDate, PriceSales , PriceStandard , SaleStatus  from tb_booklist", null);

        //arraylist 만들기
        //넣기..
        while(cursor.moveToNext()) {
            LendData lendData = new LendData();
            lendData.set_id(cursor.getInt(0));
            lendData.setImageurl(cursor.getString(1));
            lendData.setTitle(cursor.getString(2));
            lendData.setAuthor(cursor.getString(3));
            lendData.setPublisher(cursor.getString(4));
            lendData.setCategoryId(cursor.getString(5));
            lendData.setCategoryName(cursor.getString(6));
            //Log.d("category", " 2 categoryid == " +cursor.getString(5));
            lendData.setItemId(cursor.getString(7));
            lendData.setLink(cursor.getString(8));
            lendData.setCustomerReviewRank(cursor.getString(9));
            lendData.setDescription(cursor.getString(10));
            lendData.setPubDate(cursor.getString(11));
            lendData.setPriceSales(cursor.getString(12));
            lendData.setPriceStandard(cursor.getString(13));
            lendData.setSaleStatus(cursor.getString(14));

            arrayList.add(lendData);

            Log.d("database", "item == " + arrayList.size());
        }

        cursor.close();

        //어댑터 설정
        // 새로운터 클래스 만들고 list<LendData>, 휴지통 버튼
        dataAdapter = new DataAdapter(arrayList, new DataAdapter.onClickSend() {
            @Override
            public void onClickBody(LendData lendData) {
                Intent intent = new Intent(MyBookListActivity.this , BookDetailActivity.class);
                intent.putExtra("image", lendData.getImageurl());
                intent.putExtra("title" , lendData.getTitle());
                intent.putExtra("author", lendData.getAuthor());
                intent.putExtra("publisher", lendData.getPublisher());
                intent.putExtra("link", lendData.getLink());
                intent.putExtra("customerReviewRank", lendData.getCustomerReviewRank());
                intent.putExtra("itemId", lendData.getItemId());
                intent.putExtra("description", lendData.getDescription());
                intent.putExtra("pubDate", lendData.getPubDate());
                intent.putExtra("pricesales", lendData.getPriceSales());
                intent.putExtra("pricestandard", lendData.getPriceStandard());
                intent.putExtra("salestatus", lendData.getSaleStatus());
                intent.putExtra("kind" , "myData");
                startActivity(intent);

                }

            @Override
            public void onClickDelete(LendData lendData , int pos) {

//                arrayList.remove(pos);
//                dataAdapter.notifyDataSetChanged();
//                팝업띄우기
                //예 누르면
                //SQL DELETE
//                DBHelper helper = new DBHelper(getApplicationContext());
//                SQLiteDatabase db = helper.getWritableDatabase();
//                Cursor cursor = db.rawQuery("delete from tb_booklist where itemId="+lendData.getItemId(), null);

                //2가지방법
                //1. 데이터베이스에서 목록 조회해서 어댑터를 다시
                //2.
                Log.d("itemId", "itemId == " + lendData.getItemId());

                AlertDialog.Builder builder = new AlertDialog.Builder(MyBookListActivity.this);
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle("알림");
                builder.setMessage("해당 책을 삭제하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //"예" 버튼 클릭시 실행하는 메소드

                        DBHelper helper = new DBHelper(getApplicationContext());
                        SQLiteDatabase db = helper.getWritableDatabase();
//                        db.execSQL("delete from tb_booklist where itemId="+lendData.getItemId());
                        db.delete("tb_booklist" , "itemId=?" , new String[]{lendData.getItemId()});
                        db.close();
                        arrayList.remove(pos);
                        dataAdapter.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("아니오", null);
                builder.create().show();

            }
        });



        //리사이클러뷰에 SET..어댑터
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);

        myListHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBookListActivity.this , MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        myListBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}

