package com.example.michael.myapplicationnew;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

public class Registration_Activity extends AppCompatActivity {

    DataBaseHelper myDb = new DataBaseHelper(this);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.aaua_logo_small);
        ab.setTitle("Registration");
        ab.setHomeButtonEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
    }


public void onSignUpButton(View view){
    if(view.getId()==R.id.button_register){

        EditText editText_password = (EditText) findViewById(R.id.editText_password);
        EditText editText_username = (EditText) findViewById(R.id.editText_username);
        EditText editText_email = (EditText) findViewById(R.id.editText_email);
        EditText confirm_pass = (EditText) findViewById(R.id.confirm_pass);
        ImageView imageView = (ImageView) findViewById(R.id.imageView4);

        String username=editText_username.getText().toString();
        String pass=editText_password.getText().toString();
        String com_pass=confirm_pass.getText().toString();
        String email=editText_email.getText().toString();
        if(!pass.equals(com_pass)){
            Toast.makeText(Registration_Activity.this,"Password Don't Match",Toast.LENGTH_LONG).show();
        }else{

            StoreDB store=new StoreDB();
            store.setPassword(pass);
            store.setUsername(username);
            store.setEmail(email);
            store.setPassword_Com(com_pass);

            myDb.insert_data(store);

            Toast.makeText(Registration_Activity.this,"Registration Succesfully",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Registration_Activity.this,LoginActivity.class);
            startActivity(intent);
        }


    }
}




}