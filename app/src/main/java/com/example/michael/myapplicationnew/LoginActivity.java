package com.example.michael.myapplicationnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DataBaseHelper myDb = new DataBaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }




    public void onButtonClick(View view){
        if(view.getId()==R.id.button_login){

            EditText editText_username_login = (EditText) findViewById(R.id.editText_username_login);
            String str = editText_username_login.getText().toString();

            EditText editText_password_login = (EditText) findViewById(R.id.editText_password_login);
            String pass = editText_password_login.getText().toString();
            String password = myDb.searchPass(str);
                    if (pass.equals(password))

                    {
                        Intent intent = new Intent(LoginActivity.this, User.class);
                        intent.putExtra("Username ", str);
                        startActivity(intent);
                    } else

                    {
                        Toast.makeText(LoginActivity.this, "Incorrect Username or Password !", Toast.LENGTH_LONG).show();
                    }

            }
        if(view.getId()==R.id.button_register){
            Intent intent = new Intent(LoginActivity.this, Registration_Activity.class);
            startActivity(intent);
        }
    }




}





