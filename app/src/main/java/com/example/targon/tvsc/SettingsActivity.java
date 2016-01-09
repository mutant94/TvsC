package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;
    MusicPlayer mp=MusicPlayer.getPlayer(this);
    SharedPreferences sharedPreferencesPlayer;
    SharedPreferences.Editor editorPlayer;
    int idNation;
    String login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();
        Intent i=getIntent();
        login=i.getStringExtra("login");
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        idNation=sharedPreferences.getInt("idNation", 0);
        //wstawianie
        sharedPreferencesPlayer=getSharedPreferences("com.example.targon.tvsc." + login + "." + idNation, Context.MODE_PRIVATE);
        editorPlayer=sharedPreferencesPlayer.edit();
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        TextView txtRound=(TextView)findViewById(R.id.textround);
        TextView txthappy=(TextView)findViewById(R.id.texthomeland);
        TextView txtspec=(TextView)findViewById(R.id.textspecial);
        TextView viewh=(TextView)findViewById(R.id.viewhappy);
        int money=sharedPreferencesPlayer.getInt("money", -1);
        int round=sharedPreferences.getInt("countRound", -1);
        int happy=sharedPreferencesPlayer.getInt("soldierCount", 0);
        int spec=sharedPreferencesPlayer.getInt("specPoint", -1);
        happy=happy/100;
        txtMoney.setText(""+money);
        txtRound.setText(""+round);
        txthappy.setText(""+happy);
        txtspec.setText(""+spec);
        if(idNation>3){
            viewh.setText("territory");
        }
        sharedPreferencesSystem = getSharedPreferences("com.example.targon.tvsc.system.system", Context.MODE_PRIVATE);
        editorSystem = sharedPreferencesSystem.edit();
        ImageView img = (ImageView) findViewById(R.id.imgPlayMusic);
        TextView txt = (TextView) findViewById(R.id.textPlayMusic);
        boolean play = sharedPreferencesSystem.getBoolean("music", true);
        if (play==true) {
            img.setImageResource(R.drawable.mon);
            txt.setText("music on");
        } else {
            img.setImageResource(R.drawable.moff);
            txt.setText("music off");
        }
    }

    public void musicPlay(View view) {
        //zmiana icony
        sharedPreferencesSystem = getSharedPreferences("com.example.targon.tvsc.system.system", Context.MODE_PRIVATE);
        editorSystem = sharedPreferencesSystem.edit();
        ImageView img = (ImageView) findViewById(R.id.imgPlayMusic);
        TextView txt = (TextView) findViewById(R.id.textPlayMusic);
        boolean play = sharedPreferencesSystem.getBoolean("music", true);
        mp.paused(this);
        if (play==true) {
            img.setImageResource(R.drawable.moff);
            txt.setText("music off");
            editorSystem.putBoolean("music", false);
            editorSystem.commit();
        } else {
            editorSystem.putBoolean("music", true);
            editorSystem.commit();
            img.setImageResource(R.drawable.mon);
            txt.setText("music on");
        }
        //img.setImageResource(R.drawable.moff);
        //img.setImageResource(R.drawable.mon);
    }
    public void goMenu(View view) {
        Intent intent=new Intent(this, InfoActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goSoldier(View view) {
        Intent intent=new Intent(this, SoldiersActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }


    public void goAttack(View view) {
        Intent intent=new Intent(this, AtackActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goBase(View view) {
        Intent intent=new Intent(this, BaseActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);

    }

    public void goDiplomacy(View view) {
        Intent intent=new Intent(this, DiplomacyActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goHelp(View view) {
        Intent intent=new Intent(this, HelpActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goStat(View view) {
        Intent intent=new Intent(this, StatisticActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goSettings(View view) {
        Intent intent=new Intent(this, SettingsActivity.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goLogOut(View view) {
        Intent intent=new Intent(this, LoginActivity.class);
        sharedPreferencesSystem=getSharedPreferences("com.example.targon.tvsc.system.system", Context.MODE_PRIVATE);
        editorSystem=sharedPreferencesSystem.edit();
        editorSystem.putString("login", "");
        editorSystem.commit();
        startActivity(intent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
