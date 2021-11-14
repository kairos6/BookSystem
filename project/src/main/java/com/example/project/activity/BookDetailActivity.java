package com.example.project.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.database.DBHelper;
import com.example.project.database.LendData;

import java.util.ArrayList;


public class BookDetailActivity extends AppCompatActivity {

    private Button detailBackBtn;
    private Button detailMyListBtn;
    private Button detailBtn;

    TextView detailTitle;
    TextView detailAuthor;
    TextView detailPublisher;
    TextView detailLink;
    TextView detailDescription;
    TextView detailPriceStandard;
    TextView detailPriceSales;
    TextView detailSaleStatus;
    TextView detailpubDate;
    TextView detailcustomerReviewRank;
    ImageView detailImage;
    ImageView detailHome;
    ImageView detailBack;

    ArrayList<LendData> arrayList = new ArrayList<>();

    // itemid 비교

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        String detailtitle = getIntent().getStringExtra("title");
        String detailauthor = getIntent().getStringExtra("author");
        String detailpublisher = getIntent().getStringExtra("publisher");
        String detailimage = getIntent().getStringExtra("image");
        String detaillink = getIntent().getStringExtra("link");
        String detaildescription = getIntent().getStringExtra("description");
        String detailpricestandard = getIntent().getStringExtra("pricestandard");
        String detailitemid = getIntent().getStringExtra("itemId");
        String detailpricesales = getIntent().getStringExtra("pricesales");
        String detailsalestatus = getIntent().getStringExtra("salestatus");
        String detailpubdate = getIntent().getStringExtra("pubDate");
        String detailcustomerreviewrank = getIntent().getStringExtra("customerReviewRank");
        String kind = getIntent().getStringExtra("kind");
        // myData, mainData, searchData


        Log.d("kind", "kind == " + kind);

        detailMyListBtn = findViewById(R.id.detailMyList);
        detailBtn = findViewById(R.id.detailAdd);
        detailHome = findViewById(R.id.detailHome);
        detailBack = findViewById(R.id.detailBack);

        detailTitle = findViewById(R.id.detailTitle);
        detailAuthor = findViewById(R.id.detailAuthor);
        detailPublisher = findViewById(R.id.detailPublisher);
        detailImage = findViewById(R.id.detailImage);

        detailPriceStandard = findViewById(R.id.detailPriceStandard);
        detailPriceSales = findViewById(R.id.detailPriceSales);
        detailSaleStatus = findViewById(R.id.detailSaleStatus);

        detailpubDate = findViewById(R.id.detailpubDate);
        detailcustomerReviewRank = findViewById(R.id.detailcustomerReviewRank);

        detailDescription = findViewById(R.id.detailDescription);
        detailLink = findViewById(R.id.detailLink);

        //detailHomeBtn = findViewById(R.id.detailHome);

        Glide.with(this)
                .load(detailimage)
                .into(detailImage);
        detailTitle.setText(detailtitle);
        detailAuthor.setText(detailauthor);
        detailPublisher.setText(detailpublisher);

        detailPriceStandard.setText(detailpricestandard);
        detailPriceStandard.setPaintFlags(detailPriceStandard.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        detailPriceSales.setText(detailpricesales);
        detailSaleStatus.setText(detailsalestatus);

        detailpubDate.setText(detailpubdate);
        detailcustomerReviewRank.setText(detailcustomerreviewrank);

        detailLink.setText(detaillink);
        detailDescription.setText(detaildescription);

        detailLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // url 클릭 시 사이트로 이동
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(detaillink);
                intent.setData(uri);
                startActivity(intent);

            }
        });


        //책 대여, 반납
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("onclick" , "item == " + getIntent().getStringExtra("title"));

                if(detailBtn.getText().equals("추가하기"))
                {
                    //도서목록에 추가된 상태

                    // 1. 데이터베이스에 저장.

                    String image = getIntent().getStringExtra("image");
                    String title = getIntent().getStringExtra("title");
                    String author = getIntent().getStringExtra("author");
                    String publisher = getIntent().getStringExtra("publisher");
                    String categoryId = getIntent().getStringExtra("categoryId");
                    String categoryName = getIntent().getStringExtra("categoryName");
                    String itemId = getIntent().getStringExtra("itemId");
                    String link = getIntent().getStringExtra("link");
                    String customerReviewRank = getIntent().getStringExtra("customerReviewRank");
                    String description = getIntent().getStringExtra("description");
                    String pubDate = getIntent().getStringExtra("pubDate");
                    String PriceSales = getIntent().getStringExtra("pricesales");
                    String PriceStandard = getIntent().getStringExtra("pricestandard");
                    String SaleStatus = getIntent().getStringExtra("salestatus");


                    DBHelper helper = new DBHelper(BookDetailActivity.this);
                    SQLiteDatabase db = helper.getWritableDatabase();
                    Log.d("category", "1 categoryid == " + categoryId);
                    db.execSQL(" insert into tb_booklist (imageurl, title, author, publisher, categoryId, categoryName, itemId, link, customerReviewRank, description, pubDate, PriceSales ,  PriceStandard , SaleStatus ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            new String[]{image, title, author, publisher, categoryId, categoryName, itemId, link, customerReviewRank, description, pubDate, PriceSales ,  PriceStandard , SaleStatus });
                    db.close();



                    detailBtn.setText("삭제하기");
                    Toast t = Toast.makeText(BookDetailActivity.this, "내 도서목록에 추가되었습니다.", Toast.LENGTH_SHORT);
                    t.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BookDetailActivity.this);
                            builder.setIcon(android.R.drawable.ic_dialog_alert);
                            builder.setTitle("알림");
                            builder.setMessage("나의 도서목록으로 이동하시겠습니까?");
                            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    //"예" 버튼 클릭시 실행하는 메소드
                                    finish();
                                    Intent intent = new Intent(BookDetailActivity.this, MyBookListActivity.class);
                                    startActivity(intent);
                                }
                            });
                            builder.setNegativeButton("아니오", null);
                            builder.create().show();
                        }
                    }, 500);
                }
                else
                {
                    //도서목록에서 삭제된 상태
                    detailBtn.setText("추가하기");
                    //삭제
                    DBHelper helper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = helper.getWritableDatabase();
//                        db.execSQL("delete from tb_booklist where itemId="+lendData.getItemId());
                    db.delete("tb_booklist" , "itemId=?" , new String[]{detailitemid});
                    db.close();


                    Toast t = Toast.makeText(BookDetailActivity.this, "내 도서목록에서 삭제되었습니다.", Toast.LENGTH_SHORT);
                    t.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BookDetailActivity.this);
                            builder.setIcon(android.R.drawable.ic_dialog_alert);
                            builder.setTitle("알림");
                            builder.setMessage("나의 도서목록으로 이동하시겠습니까?");
                            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    //"예" 버튼 클릭시 실행하는 메소드
                                    finish();
                                    Intent intent = new Intent(BookDetailActivity.this, MyBookListActivity.class);
                                    startActivity(intent);
                                }
                            });
                            builder.setNegativeButton("아니오", null);
                            builder.create().show();
                        }
                    }, 500);

                }

            }
        });

        //내 도서로 이동
        detailMyListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetailActivity.this, MyBookListActivity.class);
                startActivity(intent);

            }
        });

        detailHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetailActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        detailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        // myData X , sear, main
        // 내부데이터 조회
        // if itemid 확인
        // 있다면 버튼을 삭제하기로

        if(kind.equals("myData"))
        {
            detailBtn.setText("삭제하기");
        }
        else if(kind.equals("mainData"))
        {
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            Cursor cursor = db.rawQuery("select _id ,imageurl, title, author, publisher, categoryId, categoryName, itemId, link, customerReviewRank, description, pubDate, PriceSales , PriceStandard , SaleStatus  from tb_booklist", null);

            while(cursor.moveToNext()) {
                LendData lendData = new LendData();
                lendData.set_id(cursor.getInt(0));
                lendData.setImageurl(cursor.getString(1));
                lendData.setTitle(cursor.getString(2));
                lendData.setAuthor(cursor.getString(3));
                lendData.setPublisher(cursor.getString(4));
                lendData.setCategoryId(cursor.getString(5));
                lendData.setCategoryName(cursor.getString(6));lendData.setItemId(cursor.getString(7));
                lendData.setLink(cursor.getString(8));
                lendData.setCustomerReviewRank(cursor.getString(9));
                lendData.setDescription(cursor.getString(10));
                lendData.setPubDate(cursor.getString(11));
                lendData.setPriceSales(cursor.getString(12));
                lendData.setPriceStandard(cursor.getString(13));
                lendData.setSaleStatus(cursor.getString(14));

                if(detailitemid.equals(cursor.getString(7)))
                {
                    detailBtn.setText("삭제하기");
                }

                arrayList.add(lendData);

                Log.d("database", "item == " + arrayList.size());
            }

            cursor.close();

        }
        else if(kind.equals("searchData"))
        {
            DBHelper helper2 = new DBHelper(this);
            SQLiteDatabase db2 = helper2.getWritableDatabase();
            Cursor cursor2 = db2.rawQuery("select _id ,imageurl, title, author, publisher, categoryId, categoryName, itemId, link, customerReviewRank, description, pubDate, PriceSales , PriceStandard , SaleStatus  from tb_booklist", null);

            while(cursor2.moveToNext()) {
                LendData lendData = new LendData();
                lendData.set_id(cursor2.getInt(0));
                lendData.setImageurl(cursor2.getString(1));
                lendData.setTitle(cursor2.getString(2));
                lendData.setAuthor(cursor2.getString(3));
                lendData.setPublisher(cursor2.getString(4));
                lendData.setCategoryId(cursor2.getString(5));
                lendData.setCategoryName(cursor2.getString(6));
                //Log.d("category", " 2 categoryid == " +cursor.getString(5));
                lendData.setItemId(cursor2.getString(7));
                lendData.setLink(cursor2.getString(8));
                lendData.setCustomerReviewRank(cursor2.getString(9));
                lendData.setDescription(cursor2.getString(10));
                lendData.setPubDate(cursor2.getString(11));
                lendData.setPriceSales(cursor2.getString(12));
                lendData.setPriceStandard(cursor2.getString(13));
                lendData.setSaleStatus(cursor2.getString(14));

                if(detailitemid.equals(cursor2.getString(7)))
                {
                    detailBtn.setText("삭제하기");
                }

                arrayList.add(lendData);

                Log.d("database", "item == " + arrayList.size());
            }

            cursor2.close();
        }

    }
}