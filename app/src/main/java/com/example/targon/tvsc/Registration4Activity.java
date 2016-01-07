package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Registration4Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String login;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration4);
        getSupportActionBar().hide();
        Intent i=getIntent();
        login=i.getStringExtra("login");
        id=i.getIntExtra("id", 0);

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    public void goGame1(View view){
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        int lvl=1;
        int idNation=id;
        int countRound=0;
        editor.putInt("lvl", lvl);
        editor.putInt("idNation", idNation);
        editor.putInt("countRound", countRound);
        editor.commit();
        Intent intent=new Intent(this, InfoActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("newable", true);
        startActivity(intent);
    }
    public void goGame2(View view){
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc."+login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        int lvl=2;
        int idNation=id;
        int countRound=0;
        editor.putInt("lvl", lvl);
        editor.putInt("idNation", idNation);
        editor.putInt("countRound", countRound);
        editor.commit();
        Intent intent=new Intent(this, InfoActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("newable", true);
        startActivity(intent);
    }
    public void goGame3(View view){
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc."+login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        int lvl=3;
        int idNation=id;
        int countRound=0;
        editor.putInt("lvl", lvl);
        editor.putInt("idNation", idNation);
        editor.putInt("countRound", countRound);
        editor.commit();
        Intent intent=new Intent(this, InfoActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("newable", true);
        startActivity(intent);
    }
}
