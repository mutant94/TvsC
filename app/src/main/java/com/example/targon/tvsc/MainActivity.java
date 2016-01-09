package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferencesSystem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        MusicPlayer mp=MusicPlayer.getPlayer(this);

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
        sharedPreferencesSystem=getSharedPreferences("com.example.targon.tvsc.system.system", Context.MODE_PRIVATE);

        String login=sharedPreferencesSystem.getString("login", "");
        if(login.equals("")) {
            intent = new Intent(this, LoginActivity.class);
        }else {
            intent = new Intent(this, InfoActivity.class);
            intent.putExtra("login", login);
        }
        startActivity(intent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
