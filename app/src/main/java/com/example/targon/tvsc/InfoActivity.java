package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences1;
    SharedPreferences sharedPreferences2;
    SharedPreferences sharedPreferences3;
    SharedPreferences sharedPreferences4;
    SharedPreferences sharedPreferences5;
    SharedPreferences sharedPreferences6;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor1;
    SharedPreferences.Editor editor2;
    SharedPreferences.Editor editor3;
    SharedPreferences.Editor editor4;
    SharedPreferences.Editor editor5;
    SharedPreferences.Editor editor6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();
        Intent i=getIntent();
        String login=i.getStringExtra("login");
        //ogół
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //nacje
        sharedPreferences1=getSharedPreferences("com.example.targon.tvsc." + login+".1", Context.MODE_PRIVATE);
        editor1=sharedPreferences1.edit();
        sharedPreferences2=getSharedPreferences("com.example.targon.tvsc." + login+".2", Context.MODE_PRIVATE);
        editor2=sharedPreferences2.edit();
        sharedPreferences3=getSharedPreferences("com.example.targon.tvsc." + login+".3", Context.MODE_PRIVATE);
        editor3=sharedPreferences3.edit();
        sharedPreferences4=getSharedPreferences("com.example.targon.tvsc." + login+".4", Context.MODE_PRIVATE);
        editor4=sharedPreferences4.edit();
        sharedPreferences5=getSharedPreferences("com.example.targon.tvsc." + login+".5", Context.MODE_PRIVATE);
        editor5=sharedPreferences5.edit();
        sharedPreferences6=getSharedPreferences("com.example.targon.tvsc." + login+".6", Context.MODE_PRIVATE);
        editor6=sharedPreferences6.edit();

        int countRound=sharedPreferences.getInt("countRound", -1);
        int lvl=sharedPreferences.getInt("lvl", 0);
        int idNation=sharedPreferences.getInt("idNation", 0);
        //tworzenie
        if(countRound==0){

        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        //finish();
    }

    public void goMenu(View view) {

    }

    public void goSoldier(View view) {
    }


    public void goAttack(View view) {

    }

    public void goBase(View view) {

    }

    public void goDiplomacy(View view) {

    }

    public void goHelp(View view) {

    }

    public void goStat(View view) {

    }

    public void goSettings(View view) {

    }

    public void goLogOut(View view) {

    }

    public void nextRuond(){

    }
}
