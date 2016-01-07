package com.example.targon.tvsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registration2Activity extends AppCompatActivity {
    String login;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        getSupportActionBar().hide();
        Intent i=getIntent();
        login=i.getStringExtra("login");
        if(login.equals("")){
            TextView textView=(TextView)findViewById(R.id.text1title);
            textView.setText("okkkkkkurczeeeeeeee!!! "+login);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void goregtero(View view) {
        intent=new Intent(this, Registration3Activity.class);
        intent.putExtra("login", login);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

    public void goregcoun(View view) {
        intent=new Intent(this, Registration3Activity.class);
        intent.putExtra("login", login);
        intent.putExtra("id", 1);
        startActivity(intent);
    }
}
