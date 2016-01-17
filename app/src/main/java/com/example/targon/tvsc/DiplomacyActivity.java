package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiplomacyActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;
    SharedPreferences sharedPreferencesPlayer;
    SharedPreferences.Editor editorPlayer;
    String login;
    int idNation;
    String at1="USA";
    String at2="Russia";
    String at3="EU";
    String ac1="ISIS";
    String ac2="Boko Haram";
    String ac3="Al Shabad";
    String no="nothing";

    String buy="cost 100 spec";
    String cbu="can't buy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplomacy);
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
        int agentCount=sharedPreferencesPlayer.getInt("agentCount", 0);
        int attackspec=sharedPreferences.getInt("specAttack",-1);
        Button bleft=(Button)findViewById(R.id.butleft);
        Button bcent=(Button)findViewById(R.id.butcent);
        Button bright=(Button)findViewById(R.id.butright);
        Button buysp=(Button)findViewById(R.id.buySpec);
        TextView txtspe=(TextView)findViewById(R.id.txtspec);
        TextView txtfun=(TextView)findViewById(R.id.functionspec);
        txtspe.setText("currently-"+agentCount);
        if(spec>=100){
            buysp.setText(buy);
        }else {
            buysp.setText(cbu);
        }
        if(agentCount==0){
            bleft.setBackgroundDrawable(null);
            bright.setBackgroundDrawable(null);
            bcent.setBackgroundDrawable(null);
            bleft.setText("");
            bright.setText("");
            bcent.setText("");
            txtfun.setText("");
        }else{
            bleft.setBackgroundColor(Color.parseColor("#AA0000"));
            bright.setBackgroundColor(Color.parseColor("#AA0000"));
            bcent.setBackgroundColor(Color.parseColor("#AA0000"));
            if(idNation>3){
                bleft.setText(at1);
                bcent.setText(at2);
                bright.setText(at3);
                switch (attackspec){
                    case 0:
                        txtfun.setText(no);
                        break;
                    case 1:
                        txtfun.setText(at1);
                        bleft.setText(no);
                        break;
                    case 2:
                        txtfun.setText(at2);
                        bcent.setText(no);
                        break;
                    case 3:
                        txtfun.setText(at3);
                        bright.setText(no);
                        break;
                }
            }else {
                bleft.setText(ac1);
                bcent.setText(ac2);
                bright.setText(ac3);
                switch (attackspec){
                    case 0:
                        txtfun.setText(no);
                        break;
                    case 4:
                        txtfun.setText(ac1);
                        bleft.setText(no);
                        break;
                    case 5:
                        txtfun.setText(ac2);
                        bcent.setText(no);
                        break;
                    case 6:
                        txtfun.setText(ac3);
                        bright.setText(no);
                        break;
                }

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
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void buySpec(View view) {
        int spec=sharedPreferencesPlayer.getInt("specPoint", -1);

        int agentCount=sharedPreferencesPlayer.getInt("agentCount", 0);
        int attackspec=sharedPreferences.getInt("specAttack",-1);
        Button bleft=(Button)findViewById(R.id.butleft);
        Button bcent=(Button)findViewById(R.id.butcent);
        Button bright=(Button)findViewById(R.id.butright);
        Button buysp=(Button)findViewById(R.id.buySpec);
        bleft.setBackgroundColor(Color.parseColor("#AA0000"));
        bright.setBackgroundColor(Color.parseColor("#AA0000"));
        bcent.setBackgroundColor(Color.parseColor("#AA0000"));
        TextView txtspe=(TextView)findViewById(R.id.txtspec);
        TextView txtfun=(TextView)findViewById(R.id.functionspec);
        TextView txtspec=(TextView)findViewById(R.id.textspecial);
        if(spec>=100){
            spec=spec-100;
            editorPlayer.putInt("specPoint", spec);
            editorPlayer.putInt("agentCount", ++agentCount);
            editor.putInt("specAttack", 0);
            editorPlayer.commit();
            editor.commit();
            txtspec.setText(""+spec);
            if(agentCount==1) {
                if (idNation > 3) {
                    bleft.setText(at1);
                    bright.setText(at3);
                    bcent.setText(at2);
                    txtfun.setText(no);

                } else {
                    bleft.setText(ac1);
                    bright.setText(ac3);
                    bcent.setText(ac2);
                    txtfun.setText(no);

                }


            }


        }
        txtspe.setText("actual-"+agentCount);
        if(spec<100){
            buysp.setText(cbu);
        }
        if(agentCount==0){
            bleft.setBackgroundDrawable(null);
            bright.setBackgroundDrawable(null);
            bcent.setBackgroundDrawable(null);
            bleft.setText("");
            bright.setText("");
            bcent.setText("");
        }



    }

    public void spec1(View view) {
        int agentCount=sharedPreferencesPlayer.getInt("agentCount", 0);
        int attackspec=sharedPreferences.getInt("specAttack",-1);
        Button bleft=(Button)findViewById(R.id.butleft);
        Button bcent=(Button)findViewById(R.id.butcent);
        Button bright=(Button)findViewById(R.id.butright);

        TextView txtfun=(TextView)findViewById(R.id.functionspec);
        if(agentCount>0){
            if(idNation>3){
                bleft.setText(at1);
                bcent.setText(at2);
                bright.setText(at3);
                if(attackspec==0){
                    bleft.setText(no);
                    txtfun.setText(at1);
                    editor.putInt("specAttack", 1);
                    editor.commit();
                }else if(attackspec==1){
                    bleft.setText(at1);
                    txtfun.setText(no);
                    editor.putInt("specAttack", 0);
                    editor.commit();
                }else{
                    bleft.setText(no);
                    txtfun.setText(at1);
                    editor.putInt("specAttack", 1);
                    editor.commit();
                }
            }else{
                bleft.setText(ac1);
                bcent.setText(ac2);
                bright.setText(ac3);
                if(attackspec==0){
                    bleft.setText(no);
                    txtfun.setText(ac1);
                    editor.putInt("specAttack", 4);
                    editor.commit();
                }else if(attackspec==4){
                    bleft.setText(ac1);
                    txtfun.setText(no);
                    editor.putInt("specAttack", 0);
                    editor.commit();
                }else{
                    bleft.setText(no);
                    txtfun.setText(ac1);
                    editor.putInt("specAttack", 4);
                    editor.commit();
                }
            }
        }
    }

    public void spec2(View view) {
        int agentCount=sharedPreferencesPlayer.getInt("agentCount", 0);
        int attackspec=sharedPreferences.getInt("specAttack",-1);
        Button bleft=(Button)findViewById(R.id.butleft);
        Button bcent=(Button)findViewById(R.id.butcent);
        Button bright=(Button)findViewById(R.id.butright);
        TextView txtfun=(TextView)findViewById(R.id.functionspec);
        if(agentCount>0){
            if(idNation>3){
                bleft.setText(at1);
                bcent.setText(at2);
                bright.setText(at3);
                if(attackspec==0){
                    bcent.setText(no);
                    txtfun.setText(at2);
                    editor.putInt("specAttack", 2);
                    editor.commit();
                }else if(attackspec==2){
                    bcent.setText(at2);
                    txtfun.setText(no);
                    editor.putInt("specAttack", 0);
                    editor.commit();
                }else{
                    bcent.setText(no);
                    txtfun.setText(at2);
                    editor.putInt("specAttack", 2);
                    editor.commit();
                }
            }else{
                bleft.setText(ac1);
                bcent.setText(ac2);
                bright.setText(ac3);
                txtfun.setText(no);
                if(attackspec==0){
                    bcent.setText(no);
                    txtfun.setText(ac2);
                    editor.putInt("specAttack", 5);
                    editor.commit();
                }else if(attackspec==5){
                    bcent.setText(ac2);
                    txtfun.setText(no);
                    editor.putInt("specAttack", 0);
                    editor.commit();
                }else{
                    bcent.setText(no);
                    txtfun.setText(ac2);
                    editor.putInt("specAttack", 5);
                    editor.commit();
                }
            }
        }
    }

    public void spec3(View view) {
        int agentCount=sharedPreferencesPlayer.getInt("agentCount", 0);
        int attackspec=sharedPreferences.getInt("specAttack",-1);
        Button bleft=(Button)findViewById(R.id.butleft);
        Button bcent=(Button)findViewById(R.id.butcent);
        Button bright=(Button)findViewById(R.id.butright);
        TextView txtfun=(TextView)findViewById(R.id.functionspec);
        if(agentCount>0){
            if(idNation>3){
                bleft.setText(at1);
                bcent.setText(at2);
                bright.setText(at3);
                if(attackspec==0){
                    bright.setText(no);
                    txtfun.setText(at3);
                    editor.putInt("specAttack", 3);
                    editor.commit();
                }else if(attackspec==3){
                    bright.setText(at3);
                    txtfun.setText(no);
                    editor.putInt("specAttack", 0);
                    editor.commit();
                }else{
                    bright.setText(no);
                    txtfun.setText(at3);
                    editor.putInt("specAttack", 3);
                    editor.commit();
                }
            }else{
                bleft.setText(ac1);
                bcent.setText(ac2);
                bright.setText(ac3);
                if(attackspec==0){
                    bright.setText(no);
                    txtfun.setText(ac3);
                    editor.putInt("specAttack", 6);
                    editor.commit();
                }else if(attackspec==6){
                    bright.setText(ac3);
                    txtfun.setText(no);
                    editor.putInt("specAttack", 0);
                    editor.commit();
                }else{
                    bright.setText(no);
                    txtfun.setText(ac3);
                    editor.putInt("specAttack", 6);
                    editor.commit();
                }
            }
        }
    }
}
