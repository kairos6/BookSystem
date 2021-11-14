package com.example.project.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import okhttp3.internal.Version;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public DBHelper(Context context) {
        super(context, "booklistdb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String booklistSQL="create table tb_booklist " +
                "(_id integer primary key autoincrement," +
                "imageurl, " +
                "title," +
                "author, " +
                "publisher," +
                "categoryId," +
                "categoryName," +
                "itemId," +
                "link," +
                "customerReviewRank," +
                "description," +
                "pubDate,"+
                "PriceSales,"+
                "PriceStandard,"+
                "SaleStatus)";

        db.execSQL(booklistSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion==DATABASE_VERSION){
            db.execSQL("drop table tb_booklist");
            onCreate(db);
        }
    }
}
