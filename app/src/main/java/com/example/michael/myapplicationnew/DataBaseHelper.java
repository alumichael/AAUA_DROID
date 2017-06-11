package com.example.michael.myapplicationnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.TextView;

import static android.R.attr.id;
import static android.R.attr.version;
import static android.content.ContentValues.TAG;



public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME3="android.db";
    public static final String TABLE_NAME2="user_data";

    public static final String COLUMN_USERNAME="username";
    public static final String ID="id";
    public static final String EMAIL="email";
    public static final String COLUMN_PASS="password";
    public static final String CONFIRM_PASSWORD="confirm_password";
    public static final String CREATE_DB_TABLE2= " create table " + TABLE_NAME2 +
            " (id integer primary key , " +
            " username text not null, " +
            " email text not null, " +
            " password text not null, " +
            " confirm_password text not null);" ;
    SQLiteDatabase db;
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME3, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DB_TABLE2);
        this.db=db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME2);
        onCreate(db);


    }


    public void insert_data(StoreDB store) {

        db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String query="select * from user_data";
        Cursor cursor=db.rawQuery(query , null);

        int count=cursor.getCount();
        contentValues.put(ID, count);
        contentValues.put(COLUMN_USERNAME, store.getUsername());
        contentValues.put(COLUMN_PASS, store.getPassword());
        contentValues.put(EMAIL, store.getEmail());
        contentValues.put(CONFIRM_PASSWORD, store.getPassword_Com());
           db.insert(TABLE_NAME2,null,contentValues);

    }

    public String searchPass(String username){

        SQLiteDatabase db = this. getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from  " + TABLE_NAME2 + " where "+COLUMN_USERNAME + " =? "+ " and " + COLUMN_PASS + " = ?" , new String[]{username});
       // String query="select username, password from "+TABLE_NAME2;
       // Cursor cursor=db.rawQuery(query, null);

        String a,b;
        b="Not Found !";
        if(cursor.moveToFirst()){

            do{
                a=cursor.getString(0);
                if(a.equals(username)){
                    b=cursor.getString(1);
                }

            }while(cursor.moveToNext());
        }

        return b;
    }
}
