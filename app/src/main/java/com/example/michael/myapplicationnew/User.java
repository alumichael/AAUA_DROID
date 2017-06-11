package com.example.michael.myapplicationnew;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.michael.myapplicationnew.DataBaseHelper.COLUMN_USERNAME;

public class User extends AppCompatActivity {
private static TextView text_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        String username=getIntent().getStringExtra("Username");
        text_user_name=(TextView) findViewById(R.id.text_user_name);
        text_user_name.setText(username);







    }



}
