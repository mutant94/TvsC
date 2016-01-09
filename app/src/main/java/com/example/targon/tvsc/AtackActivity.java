package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AtackActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferencesPlayer;
    SharedPreferences.Editor editorPlayer;
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;
    String login;
    int idNation;
    String function="nothing";
    String functiona4="attack isis";
    String functiona5="attack boko haram";
    String functiona6="attack al shabad";
    String funac="actual ";
    String fundef="defended";
    String funcam="camufalge";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atack);
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
        //wiadomo
        Button bleft=(Button)findViewById(R.id.butleft);
        Button bcent=(Button)findViewById(R.id.butcent);
        Button bright=(Button)findViewById(R.id.butright);
        TextView textf=(TextView)findViewById(R.id.function);
        int fun=sharedPreferences.getInt("attack", -1);
        if(idNation>3){
            bleft.setBackgroundDrawable(null);
            bright.setBackgroundDrawable(null);
            bleft.setText("");
            bright.setText("");
            if(fun==1){
                textf.setText(funac+fundef);
                bcent.setText("change to " + funcam);
            }else{
                textf.setText(funac+funcam);
                bcent.setText("change to " + fundef);
            }

        }else {
            bleft.setText(functiona4);
            bcent.setText(functiona5);
            bright.setText(functiona6);
            switch (fun){
                case 0:
                    textf.setText(funac+function);
                    break;
                case 4:
                    bleft.setText("change to "+function);
                    textf.setText(funac+functiona4);
                    break;
                case 5:
                    bcent.setText("change to "+function);
                    textf.setText(funac+functiona5);
                    break;
                case 6:
                    bright.setText("change to "+function);
                    textf.setText(funac+functiona6);
                    break;
            }
        }


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

    public void atack1(View view) {
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        Button bleft=(Button)findViewById(R.id.butleft);
        TextView textf=(TextView)findViewById(R.id.function);
        if(idNation<4){
            int fun=sharedPreferences.getInt("attack", -1);
            if(fun==0){
                editor.putInt("attack", 4);
                editor.commit();
                bleft.setText("change to "+function);
                textf.setText(funac+functiona4);
            }else{
                editor.putInt("attack", 0);
                editor.commit();
                bleft.setText("change to "+functiona4);
                textf.setText(funac+function);
            }
        }
    }

    public void atack2(View view) {
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        int fun=sharedPreferences.getInt("attack", -1);
        Button bcent=(Button)findViewById(R.id.butcent);
        TextView textf=(TextView)findViewById(R.id.function);
        if(idNation<4){
            if(fun==0){
                editor.putInt("attack", 5);
                editor.commit();
                bcent.setText("change to "+function);
                textf.setText(funac+functiona5);
            }else{
                editor.putInt("attack", 0);
                editor.commit();
                bcent.setText("change to "+functiona4);
                textf.setText(funac+function);
            }
        }else {
            if(fun==0){
                editor.putInt("attack", 1);
                editor.commit();
                bcent.setText("change to "+funcam);
                textf.setText(funac+fundef);
            }else{
                editor.putInt("attack", 0);
                editor.commit();
                bcent.setText("change to "+fundef);
                textf.setText(funac+funcam);
            }
        }
    }

    public void atack3(View view) {
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        Button bright=(Button)findViewById(R.id.butright);
        TextView textf=(TextView)findViewById(R.id.function);
        if(idNation<4){
            int fun=sharedPreferences.getInt("attack", -1);
            if(fun==0){
                editor.putInt("attack", 5);
                editor.commit();
                bright.setText("change to "+function);
                textf.setText(funac+functiona4);
            }else{
                editor.putInt("attack", 0);
                editor.commit();
                bright.setText("change to "+functiona5);
                textf.setText(funac+function);
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
