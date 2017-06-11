package com.example.michael.myapplicationnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private static EditText editText_password;
    private static EditText editText_username,name,email;
    private static TextView username,password,text_register_here;
    private static ImageButton imageButton;
    private static Button button_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onhomeclick);

        editText_password= (EditText)findViewById(R.id.editText_password);
        editText_username= (EditText)findViewById(R.id.editText_username);

        username=(TextView)findViewById(R.id.username);
        password=(TextView)findViewById(R.id.password);
        button_login=(Button)findViewById(R.id.button_login);
        text_register_here=(TextView) findViewById(R.id.text_register_here);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                break;
            case R.id.text_register_here:
                startActivity(new Intent(this,Registration_Activity.class));
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_, menu);



        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_info) {
            return true;
        }
        if (id == R.id.action_share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
