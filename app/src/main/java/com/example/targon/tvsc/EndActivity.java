package com.example.targon.tvsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        getSupportActionBar().hide();
        Intent i =getIntent();
        String txt= i.getStringExtra("game");
        TextView txtend=(TextView)findViewById(R.id.txtend);
        txtend.setText(txt);

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

    private void goNext() {
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
