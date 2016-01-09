package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;

    String login;

    int countRound;
    int lvl;
    int idNation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();
        Intent i=getIntent();
        login=i.getStringExtra("login");
        //zapamiętanie
        sharedPreferencesSystem=getSharedPreferences("com.example.targon.tvsc.system.system", Context.MODE_PRIVATE);
        editorSystem=sharedPreferencesSystem.edit();
        editorSystem.putString("login", login);
        editorSystem.commit();
        //ogół
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //nacje
        sharedPreferences1=getSharedPreferences("com.example.targon.tvsc." + login+".1", Context.MODE_PRIVATE);
        editor1=sharedPreferences1.edit();
        sharedPreferences2=getSharedPreferences("com.example.targon.tvsc." + login + ".2", Context.MODE_PRIVATE);
        editor2=sharedPreferences2.edit();
        sharedPreferences3=getSharedPreferences("com.example.targon.tvsc." + login + ".3", Context.MODE_PRIVATE);
        editor3=sharedPreferences3.edit();
        sharedPreferences4=getSharedPreferences("com.example.targon.tvsc." + login + ".4", Context.MODE_PRIVATE);
        editor4=sharedPreferences4.edit();
        sharedPreferences5=getSharedPreferences("com.example.targon.tvsc." + login + ".5", Context.MODE_PRIVATE);
        editor5=sharedPreferences5.edit();
        sharedPreferences6=getSharedPreferences("com.example.targon.tvsc." + login + ".6", Context.MODE_PRIVATE);
        editor6=sharedPreferences6.edit();

        countRound=sharedPreferences.getInt("countRound", -1);
        lvl=sharedPreferences.getInt("lvl", 0);
        idNation=sharedPreferences.getInt("idNation", 0);
        if(idNation==0){
            Intent intent=new Intent(this, Registration2Activity.class);
            intent.putExtra("login", login);
            startActivity(intent);
        }
        //tworzenie
        if(countRound==0){
            editor.putInt("attack",0);
            editor.putInt("specAttack",0);
            editor.commit();
            //1u
            editor1.putInt("money", 1000);
            editor1.putInt("specPoint", 0);
            editor1.putInt("soldierCount", 5000);
            editor1.putInt("airCount", 0);
            editor1.putInt("navyCount", 0);
            editor1.putInt("dronCount", 0);
            editor1.putInt("surCount", 10);
            editor1.putInt("otherCount", 0);
            editor1.putInt("agentCount", 0);
            editor1.putBoolean("looser", false);
            editor1.commit();
            //2r
            editor2.putInt("money", 1000);
            editor2.putInt("specPoint", 0);
            editor2.putInt("soldierCount", 7500);
            editor2.putInt("airCount", 0);
            editor2.putInt("navyCount", 0);
            editor2.putInt("dronCount", 0);
            editor2.putInt("surCount", 0);
            editor2.putInt("otherCount", 0);
            editor2.putInt("agentCount", 0);
            editor2.putBoolean("looser", false);
            editor2.commit();
            //3e
            editor3.putInt("money", 1000);
            editor3.putInt("specPoint", 10);
            editor3.putInt("soldierCount", 5000);
            editor3.putInt("airCount", 0);
            editor3.putInt("navyCount", 0);
            editor3.putInt("dronCount", 0);
            editor3.putInt("surCount", 0);
            editor3.putInt("otherCount", 0);
            editor3.putInt("agentCount", 0);
            editor3.putBoolean("looser", false);
            editor3.commit();
            //4i
            editor4.putInt("money", 100);
            editor4.putInt("specPoint", 0);
            editor4.putInt("soldierCount", 5000);
            editor4.putInt("airCount", 0);
            editor4.putInt("navyCount", 0);
            editor4.putInt("dronCount", 0);
            editor4.putInt("surCount", 10);
            editor4.putInt("otherCount", 0);
            editor4.putInt("agentCount", 0);
            editor4.putBoolean("looser", false);
            editor4.commit();
            //5b
            editor5.putInt("money", 1000);
            editor5.putInt("specPoint", 10);
            editor5.putInt("soldierCount", 5000);
            editor5.putInt("airCount", 0);
            editor5.putInt("navyCount", 0);
            editor5.putInt("dronCount", 0);
            editor5.putInt("surCount", 0);
            editor5.putInt("otherCount", 0);
            editor5.putInt("agentCount", 0);
            editor5.putBoolean("looser", false);
            editor5.commit();
            //6a
            editor6.putInt("money", 100);
            editor6.putInt("specPoint", 0);
            editor6.putInt("soldierCount", 7500);
            editor6.putInt("airCount", 0);
            editor6.putInt("navyCount", 0);
            editor6.putInt("dronCount", 0);
            editor6.putInt("surCount", 0);
            editor6.putInt("otherCount", 0);
            editor6.putInt("agentCount", 0);
            editor6.putBoolean("looser", false);
            editor6.commit();
            //end
            //countRound=1;
        }
        //wstawianie
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        TextView txtRound=(TextView)findViewById(R.id.textround);
        TextView txthappy=(TextView)findViewById(R.id.texthomeland);
        TextView txtspec=(TextView)findViewById(R.id.textspecial);
        TextView viewh=(TextView)findViewById(R.id.viewhappy);
        int money=0;
        int round=sharedPreferences.getInt("countRound", -1);
        int happy=0;
        int spec=0;
        if(idNation>3){
            viewh.setText("territory");
        }
        switch (idNation){
            case 1:
                money=sharedPreferences1.getInt("money", -1);
                happy=sharedPreferences1.getInt("soldierCount", 0);
                spec=sharedPreferences1.getInt("specPoint", -1);
                happy=happy/100;
                break;
            case 2:
                money=sharedPreferences2.getInt("money", -1);
                happy=sharedPreferences2.getInt("soldierCount", 0);
                spec=sharedPreferences2.getInt("specPoint", -1);
                happy=happy/100;
                break;
            case 3:
                money=sharedPreferences3.getInt("money", -1);
                happy=sharedPreferences3.getInt("soldierCount", 0);
                spec=sharedPreferences3.getInt("specPoint", -1);
                happy=happy/100;
                break;
            case 4:
                money=sharedPreferences4.getInt("money", -1);
                happy=sharedPreferences4.getInt("soldierCount", 0);
                spec=sharedPreferences4.getInt("specPoint", -1);
                happy=happy/100;
                break;
            case 5:
                money=sharedPreferences5.getInt("money", -1);
                happy=sharedPreferences5.getInt("soldierCount", 0);
                spec=sharedPreferences5.getInt("specPoint", -1);
                happy=happy/100;
                break;
            case 6:
                money=sharedPreferences6.getInt("money", -1);
                happy=sharedPreferences6.getInt("soldierCount", 0);
                spec=sharedPreferences6.getInt("specPoint", -1);
                happy=happy/100;
                break;
        }
        txtMoney.setText(""+money);
        txtRound.setText(""+round);
        txthappy.setText(""+happy);
        txtspec.setText(""+spec);

    }


    @Override
    protected void onPause() {
        super.onPause();
        //finish();
    }

    public void goMenu(View view) {
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

    public void nextRound(View view){

    }

    public void exit(View view){
        System.exit(0);
    }
}
