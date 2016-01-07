package com.example.targon.tvsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    goNext();
                }
            }
        };
        thread.start();
    }
    public void goNext(){
        Intent intent;
        intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
