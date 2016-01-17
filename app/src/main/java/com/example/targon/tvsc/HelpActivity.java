package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    String login;
    int idNation;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;

    SharedPreferences sharedPreferencesPlayer;
    SharedPreferences.Editor editorPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
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

    public void helpwin(View view) {
        TextView textView=(TextView)findViewById(R.id.txtResolve);
        textView.setText("Countries win if every terrorist group has no stat points(territory gains). Whether one of terrorist group has 100 territory, it wins. If country happiness is none, this country loses. When Player has no points, game is over and user loses");
    }

    public void helpunit(View view) {
        TextView textView=(TextView)findViewById(R.id.txtResolve);
        textView.setText("Soldiers generate territory gains(terrorist) or happiness(countries). Every round you lose several soldiers. Drones and radar increase damage. Planes and ships can attack all type of terrorist units. Terrorist's anti-navy missiles attack ships and anti-air ones attack enemy's aircraft.");
    }

    public void helpspec(View view) {
        TextView textView=(TextView)findViewById(R.id.txtResolve);
        textView.setText("Every round you get +10 special point(Europe and Boko Haram get +20)" +"\n"+
                "Sent special agent destroys 10%-70% enemy soldier's. Alternatively if enemy has 1000 or less soldiers he loses the game due to special agent. ");
    }

    public void helpmoney(View view) {
        TextView textView=(TextView)findViewById(R.id.txtResolve);
        textView.setText("Every conflict side gets income from happiness or territory calculated as following: 30*happiness(countries) or 20*territory(terrorists)" + "\n"+
                "Each oil well income: 60(countries) or 30(terrorists)" +"\n"+
                "Factories in countries give you 30 money units" +"\n"+
                "Terrorist group gives you 20 m. units");
    }
}
