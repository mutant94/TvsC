package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatisticActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences1;
    SharedPreferences sharedPreferences2;
    SharedPreferences sharedPreferences3;
    SharedPreferences sharedPreferences4;
    SharedPreferences sharedPreferences5;
    SharedPreferences sharedPreferences6;
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;

    String login;
    int idNation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        getSupportActionBar().hide();
        Intent i=getIntent();
        login=i.getStringExtra("login");
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc." + login, Context.MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("com.example.targon.tvsc." + login + ".1", Context.MODE_PRIVATE);
        sharedPreferences2=getSharedPreferences("com.example.targon.tvsc." + login + ".2", Context.MODE_PRIVATE);
        sharedPreferences3=getSharedPreferences("com.example.targon.tvsc." + login + ".3", Context.MODE_PRIVATE);
        sharedPreferences4=getSharedPreferences("com.example.targon.tvsc." + login + ".4", Context.MODE_PRIVATE);
        sharedPreferences5=getSharedPreferences("com.example.targon.tvsc." + login + ".5", Context.MODE_PRIVATE);
        sharedPreferences6=getSharedPreferences("com.example.targon.tvsc." + login + ".6", Context.MODE_PRIVATE);
        TextView textname1=(TextView)findViewById(R.id.name1);
        TextView textpoint1=(TextView)findViewById(R.id.point1);
        TextView textname2=(TextView)findViewById(R.id.name2);
        TextView textpoint2=(TextView)findViewById(R.id.point2);
        TextView textname3=(TextView)findViewById(R.id.name3);
        TextView textpoint3=(TextView)findViewById(R.id.point3);
        TextView textname4=(TextView)findViewById(R.id.name4);
        TextView textpoint4=(TextView)findViewById(R.id.point4);
        TextView textname5=(TextView)findViewById(R.id.name5);
        TextView textpoint5=(TextView)findViewById(R.id.point5);
        TextView textname6=(TextView)findViewById(R.id.name6);
        TextView textpoint6=(TextView)findViewById(R.id.point6);

        idNation=sharedPreferences.getInt("idNation", 0);
        int s1=sharedPreferences1.getInt("soldierCount", -1);
        int s2=sharedPreferences2.getInt("soldierCount", -1);;
        int s3=sharedPreferences3.getInt("soldierCount", -1);;
        int s4=sharedPreferences4.getInt("soldierCount", -1);;
        int s5=sharedPreferences5.getInt("soldierCount", -1);;
        int s6=sharedPreferences6.getInt("soldierCount", -1);;
        textname1.setText("USA");
        textname2.setText("Russia");
        textname3.setText("UE");
        textname4.setText("ISIS");
        textname5.setText("Boko Haram");
        textname6.setText("Al-shabad");
        Double h;
        int happy;
        h=s1*0.01;
        happy=h.intValue();
        if(happy>100){
            happy=100;
        }
        textpoint1.setText(""+happy);
        h=s2*0.01;
        happy=h.intValue();
        if(happy>100){
            happy=100;
        }
        textpoint2.setText(""+happy);
        h=s3*0.01;
        happy=h.intValue();
        if(happy>100){
            happy=100;
        }
        textpoint3.setText(""+happy);
        h=s4*0.01;
        happy=h.intValue();
        if(happy>100){
            happy=100;
        }
        textpoint4.setText(""+happy);
        h=s5*0.01;
        happy=h.intValue();
        if(happy>100){
            happy=100;
        }
        textpoint5.setText(""+happy);
        h=s6*0.01;
        happy=h.intValue();
        if(happy>100){
            happy=100;
        }
        textpoint6.setText(""+happy);
        switch (idNation){
            case 1:
                textname1.setText("USA(YOU-"+login+")");
                break;
            case 2:
                textname2.setText("Russia(YOU-"+login+")");
                break;
            case 3:
                textname3.setText("UE(YOU-"+login+")");
                break;
            case 4:
                textname4.setText("ISIS(YOU-"+login+")");
                break;
            case 5:
                textname5.setText("Boko Haram(YOU-"+login+")");
                break;
            case 6:
                textname6.setText("Al-shabad(YOU-"+login+")");
                break;
        }

        //wstawianie
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        TextView txtRound=(TextView)findViewById(R.id.textround);
        TextView txthappy=(TextView)findViewById(R.id.texthomeland);
        TextView txtspec=(TextView)findViewById(R.id.textspecial);
        TextView viewh=(TextView)findViewById(R.id.viewhappy);
        int money=0;
        int round=sharedPreferences.getInt("countRound", -1);
        happy=0;
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
