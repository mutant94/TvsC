package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

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

    SharedPreferences sharedPreferencesGame;
    SharedPreferences.Editor editorGame;

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
            editor.putInt("attack", 0);
            editor.putInt("specAttack", 0);
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
            countRound=1;
            editor.putInt("countRound", countRound);
            editor.commit();
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
        /**
         * int id;
         //1-usa, 2-rosja, 3-ue, 4-isis, 5-bokoharam, 6-alshabad
         int money;
         int specPoint;
         int soldierCount;
         int airCount;
         int navyCount;
         int dronCount;
         //inlandPonit=soldierCoount*0.01;
         int surCount;
         int otherCount;
         int agentCount;
         boolean looser;
         */
        /**
         * int countRound;
         int idNation;
         int lvl;
         int attack;
         int specAttack;
         */
        boolean playerlooser=false;
        Double doub;
        int a;
        int i=1;
        int money=0;
        int specPoint=0;
        int solcount=0;
        int aircount=0;
        int navycount=0;
        int droncount=0;
        int surcount=0;
        int othercount=0;
        int agentcount=0;
        boolean looser=true;
        //zakupy
        switch(lvl){
            case 1:

                while(i<7){
                    if(idNation!=i){
                        sharedPreferencesGame=getSharedPreferences("com.example.targon.tvsc." + login + "." + i, Context.MODE_PRIVATE);
                        editorGame=sharedPreferencesGame.edit();
                        looser=sharedPreferencesGame.getBoolean("looser", true);
                        money=sharedPreferencesGame.getInt("money", 0);
                        specPoint=sharedPreferencesGame.getInt("specPoint", 0);
                        solcount=sharedPreferencesGame.getInt("soldierCount", 0);
                        aircount=sharedPreferencesGame.getInt("airCount", 0);
                        navycount=sharedPreferencesGame.getInt("navyCount", 0);
                        droncount=sharedPreferencesGame.getInt("dronCount", 0);
                        surcount=sharedPreferencesGame.getInt("surCount", 0);
                        othercount=sharedPreferencesGame.getInt("otherCount", 0);
                        agentcount=sharedPreferencesGame.getInt("agentCount", 0);
                        if(looser==false){
                            if(i<4){
                                if(solcount<5200){
                                    doub=(double)money/10;
                                    a=doub.intValue();
                                    solcount+=a;
                                    money-=a*10;

                                }else{
                                    doub=(double)money/100;
                                    a=doub.intValue();
                                    aircount+=a;
                                    money-=a*100;

                                }

                            }else{
                                a=money;
                                solcount+=a;
                                money=0;

                            }
                        }
                        editorGame.putInt("money",money);
                        editorGame.putInt("specPoint", specPoint);
                        editorGame.putInt("soldierCount", solcount);
                        editorGame.putInt("airCount", aircount);
                        editorGame.putInt("navyCount", navycount);
                        editorGame.putInt("dronCount", droncount);
                        editorGame.putInt("surCount", surcount);
                        editorGame.putInt("otherCount", othercount);
                        editorGame.putInt("agentCount", agentcount);
                        editorGame.commit();
                    }
                    i++;
                }
                break;
            case 2:
                while(i<7){
                    if(idNation!=i){
                        sharedPreferencesGame=getSharedPreferences("com.example.targon.tvsc." + login + "." + i, Context.MODE_PRIVATE);
                        editorGame=sharedPreferencesGame.edit();
                        looser=sharedPreferencesGame.getBoolean("looser", true);
                        money=sharedPreferencesGame.getInt("money", 0);
                        specPoint=sharedPreferencesGame.getInt("specPoint", 0);
                        solcount=sharedPreferencesGame.getInt("soldierCount", 0);
                        aircount=sharedPreferencesGame.getInt("airCount", 0);
                        navycount=sharedPreferencesGame.getInt("navyCount", 0);
                        droncount=sharedPreferencesGame.getInt("dronCount", 0);
                        surcount=sharedPreferencesGame.getInt("surCount", 0);
                        othercount=sharedPreferencesGame.getInt("otherCount", 0);
                        agentcount=sharedPreferencesGame.getInt("agentCount", 0);
                        if(looser==false){
                            if(i<4){
                                if(solcount<5200){
                                    doub=(double)money/10;
                                    a=doub.intValue();
                                    solcount+=a;
                                    money-=a*10;
                                }else{
                                    if(money>=25&&droncount<6){
                                        droncount+=5;
                                        money-=25;

                                    }
                                    if(surcount<3){
                                        doub=(double)money/600;
                                        a=doub.intValue();
                                        surcount+=a;
                                        money-=a*600;
                                    }
                                    doub=(double)money/100;
                                    a=doub.intValue();
                                    aircount+=a;
                                    money-=a*100;
                                }
                            }else{
                                if(solcount<5200){
                                    doub=(double)money/10;
                                    a=doub.intValue();
                                    solcount+=a;
                                    money-=a*10;
                                }else{
                                    if(money>=5000&&droncount==0){
                                        money-=5000;
                                        ++droncount;
                                    }
                                }
                                a=money;
                                solcount+=a;
                                money=0;
                            }
                        }
                        editorGame.putInt("money",money);
                        editorGame.putInt("specPoint", specPoint);
                        editorGame.putInt("soldierCount", solcount);
                        editorGame.putInt("airCount", aircount);
                        editorGame.putInt("navyCount", navycount);
                        editorGame.putInt("dronCount", droncount);
                        editorGame.putInt("surCount", surcount);
                        editorGame.putInt("otherCount", othercount);
                        editorGame.putInt("agentCount", agentcount);
                        editorGame.commit();
                    }

                    i++;
                }
                break;
            case 3:
                while(i<7){
                    if(idNation!=i){
                        sharedPreferencesGame=getSharedPreferences("com.example.targon.tvsc." + login + "." + i, Context.MODE_PRIVATE);
                        editorGame=sharedPreferencesGame.edit();
                        looser=sharedPreferencesGame.getBoolean("looser", true);
                        money=sharedPreferencesGame.getInt("money", 0);
                        specPoint=sharedPreferencesGame.getInt("specPoint", 0);
                        solcount=sharedPreferencesGame.getInt("soldierCount", 0);
                        aircount=sharedPreferencesGame.getInt("airCount", 0);
                        navycount=sharedPreferencesGame.getInt("navyCount", 0);
                        droncount=sharedPreferencesGame.getInt("dronCount", 0);
                        surcount=sharedPreferencesGame.getInt("surCount", 0);
                        othercount=sharedPreferencesGame.getInt("otherCount", 0);
                        agentcount=sharedPreferencesGame.getInt("agentCount", 0);
                        if(looser==false){
                            if(i<4){
                                //państwa
                                if(solcount<5200){
                                    doub=(double)money/10;
                                    a=doub.intValue();
                                    solcount+=a;
                                    money-=a*10;
                                }else{
                                    if(money>=25&&droncount<6){
                                        droncount+=5;
                                        money-=25;

                                    }
                                    if(surcount<3){
                                        doub=(double)money/600;
                                        a=doub.intValue();
                                        surcount+=a;
                                        money-=a*600;
                                    }
                                    if(money>1000){
                                        money-=400;
                                        navycount+=2;
                                    }
                                    if(money>400){
                                        doub=(double)money/100-3;
                                        a=doub.intValue();
                                        aircount+=a;
                                        money-=a*100;
                                    }
                                    doub=(double)money/10;
                                    a=doub.intValue();
                                    solcount+=a;
                                    money-=a*10;

                                }
                            }else{
                                //tero
                                if(solcount<5200){
                                    doub=(double)money/10;
                                    a=doub.intValue();
                                    solcount+=a;
                                    money-=a*10;
                                }else{
                                    if(money>=5000&&droncount==0){
                                        money-=5000;
                                        ++droncount;
                                    }
                                    if(money>=300){
                                        money-=300;
                                        surcount++;
                                    }
                                    if(money>=200){
                                        money-=200;
                                        othercount++;
                                    }
                                    while(money>=20){
                                        ++aircount;
                                        ++navycount;
                                        money-=20;
                                    }
                                }
                                if(specPoint>=100){
                                    specPoint-=100;
                                    ++agentcount;
                                }
                                a=money;
                                solcount+=a;
                                money=0;
                            }
                        }
                        editorGame.putInt("money",money);
                        editorGame.putInt("specPoint", specPoint);
                        editorGame.putInt("soldierCount", solcount);
                        editorGame.putInt("airCount", aircount);
                        editorGame.putInt("navyCount", navycount);
                        editorGame.putInt("dronCount", droncount);
                        editorGame.putInt("surCount", surcount);
                        editorGame.putInt("otherCount", othercount);
                        editorGame.putInt("agentCount", agentcount);
                        editorGame.commit();
                    }

                    i++;
                }
                break;


        }
        //reszta
        Double d;
        int infoSol=-1;

        int solcount1=sharedPreferences1.getInt("soldierCount", 0);

        int solcount2=sharedPreferences2.getInt("soldierCount", 0);

        int solcount3=sharedPreferences3.getInt("soldierCount", 0);

        int solcount4=sharedPreferences4.getInt("soldierCount", 0);

        int solcount5=sharedPreferences5.getInt("soldierCount", 0);

        int solcount6=sharedPreferences6.getInt("soldierCount", 0);

        int aircount1;
        int aircount2;
        int aircount3;
        int aircount4;
        int aircount5;
        int aircount6;
        int navycount1;
        int navycount2;
        int navycount3;
        int navycount4;
        int navycount5;
        int navycount6;
        int droncount1;
        int droncount2;
        int droncount3;
        int droncount4;
        int droncount5;
        int droncount6;

        boolean l1=sharedPreferences1.getBoolean("looser", true);
        boolean l2=sharedPreferences2.getBoolean("looser", true);
        boolean l3=sharedPreferences3.getBoolean("looser", true);
        boolean l4=sharedPreferences4.getBoolean("looser", true);
        boolean l5=sharedPreferences5.getBoolean("looser", true);
        boolean l6=sharedPreferences6.getBoolean("looser", true);
        //co turówka
        if(l1==false){
            d=0.01*solcount1;
            solcount1-=d*6;
            editor1.putInt("soldierCount", solcount1);
            editor1.commit();
            if(idNation==1){
                d*=6;
                infoSol=d.intValue();
            }
        }
        if(l2==false){
            d=0.01*solcount2;
            solcount2-=d*6;
            editor2.putInt("soldierCount", solcount2);
            editor2.commit();
            if(idNation==1){
                d*=6;
                infoSol=d.intValue();
            }
        }
        if(l3==false){
            d=0.01*solcount3;
            solcount3-=d*6;
            editor3.putInt("soldierCount", solcount3);
            editor3.commit();
            if(idNation==1){
                d*=6;
                infoSol=d.intValue();
            }
        }
        if(l4==false){
            d=0.01*solcount4;
            solcount4-=d*30;
            editor4.putInt("soldierCount", solcount4);
            editor4.commit();
            if(idNation==1){
                d*=6;
                infoSol=d.intValue();
            }
        }
        if(l5==false){
            d=0.01*solcount5;
            solcount5-=d*30;
            editor5.putInt("soldierCount", solcount5);
            editor5.commit();
            if(idNation==1){
                d*=6;
                infoSol=d.intValue();
            }
        }
        if(l6==false){
            d=0.01*solcount6;
            solcount6-=d*30;
            editor6.putInt("soldierCount", solcount6);
            editor6.commit();
            if(idNation==1){
                d*=6;
                infoSol=d.intValue();
            }
        }
        //fight
        i=1;
        Random rand=new Random();
        int r;
        int a1=0;
        int a2=0;
        int a3=0;
        int ha4;
        int ha5;
        int ha6;
        while(i<7){
            sharedPreferencesGame=getSharedPreferences("com.example.targon.tvsc." + login + "." + i, Context.MODE_PRIVATE);
            editorGame=sharedPreferencesGame.edit();
            looser=sharedPreferencesGame.getBoolean("looser", true);
            solcount=sharedPreferencesGame.getInt("soldierCount", 0);
            aircount=sharedPreferencesGame.getInt("airCount", 0);
            navycount=sharedPreferencesGame.getInt("navyCount", 0);
            droncount=sharedPreferencesGame.getInt("navyCount", 0);

            solcount1=sharedPreferences1.getInt("soldierCount", 0);
            aircount1=sharedPreferences1.getInt("airCount", 0);
            navycount1=sharedPreferences1.getInt("navyCount", 0);
            droncount1=sharedPreferences1.getInt("dronCount", 0);

            solcount2=sharedPreferences2.getInt("soldierCount", 0);
            aircount2=sharedPreferences2.getInt("airCount", 0);
            navycount2=sharedPreferences2.getInt("navyCount", 0);
            droncount2=sharedPreferences2.getInt("dronCount", 0);

            solcount3=sharedPreferences3.getInt("soldierCount", 0);
            aircount3=sharedPreferences3.getInt("airCount", 0);
            navycount3=sharedPreferences3.getInt("navyCount", 0);
            droncount3=sharedPreferences3.getInt("dronCount", 0);

            solcount4=sharedPreferences4.getInt("soldierCount", 0);
            aircount4=sharedPreferences4.getInt("airCount", 0);
            navycount4=sharedPreferences4.getInt("navyCount", 0);
            droncount4=sharedPreferences4.getInt("dronCount", 0);

            solcount5=sharedPreferences5.getInt("soldierCount", 0);
            aircount5=sharedPreferences5.getInt("airCount", 0);
            navycount5=sharedPreferences5.getInt("navyCount", 0);
            droncount5=sharedPreferences5.getInt("dronCount", 0);

            solcount6=sharedPreferences6.getInt("soldierCount", 0);
            aircount6=sharedPreferences6.getInt("airCount", 0);
            navycount6=sharedPreferences6.getInt("navyCount", 0);
            droncount6=sharedPreferences6.getInt("dronCount", 0);


            if(looser==false){
                if(i<4) {
                    ha4=solcount4;
                    ha5=solcount5;
                    ha6=solcount6;
                    if(idNation==i){
                        int attack=sharedPreferences.getInt("attack", 0);
                        switch (attack){
                            case 0:
                                break;
                            case 4:
                                for(int k=0; k<aircount; k++){
                                    r=rand.nextInt(11);
                                    r*=droncount;
                                    solcount4-=r;
                                }
                                for(int k=0; k<navycount; k++){
                                    r=rand.nextInt(16);
                                    r*=droncount;
                                    solcount4-=r;
                                }
                                editor4.putInt("soldierCount", solcount);
                                break;
                            case 5:
                                for(int k=0; k<aircount; k++){
                                    r=rand.nextInt(11);
                                    r*=droncount;
                                    solcount5-=r;
                                }
                                for(int k=0; k<navycount; k++){
                                    r=rand.nextInt(16);
                                    r*=droncount;
                                    solcount5-=r;
                                }
                                editor5.putInt("soldierCount", solcount);
                                break;
                            case 6:
                                for(int k=0; k<aircount; k++){
                                    r=rand.nextInt(11);
                                    r*=droncount;
                                    solcount6-=r;
                                }
                                for(int k=0; k<navycount; k++){
                                    r=rand.nextInt(16);
                                    r*=droncount;
                                    solcount6-=r;
                                }
                                editor6.putInt("soldierCount", solcount);
                                break;

                        }
                    }else{
                        if(ha4>ha5&&ha4>ha6){
                            switch (i){
                                case 1:
                                    a1=4;
                                    break;
                                case 2:
                                    a2=4;
                                    break;
                                case 3:
                                    a3=4;
                                    break;

                            }
                            for(int k=0; k<aircount; k++){
                                r=rand.nextInt(11);
                                r*=droncount;
                                solcount4-=r;
                            }
                            for(int k=0; k<navycount; k++){
                                r=rand.nextInt(16);
                                r*=droncount;
                                solcount4-=r;
                            }
                            editor4.putInt("soldierCount", solcount);
                        }else if(ha5>ha6){
                            switch (i){
                                case 1:
                                    a1=5;
                                    break;
                                case 2:
                                    a2=5;
                                    break;
                                case 3:
                                    a3=5;
                                    break;
                            }
                            for(int k=0; k<aircount; k++){
                                r=rand.nextInt(11);
                                r*=droncount;
                                solcount5-=r;
                            }
                            for(int k=0; k<navycount; k++){
                                r=rand.nextInt(16);
                                r*=droncount;
                                solcount5-=r;
                            }
                            editor5.putInt("soldierCount", solcount);
                        }else{
                            switch (i){
                                case 1:
                                    a1=6;
                                    break;
                                case 2:
                                    a2=6;
                                    break;
                                case 3:
                                    a3=6;
                                    break;
                            }
                            for(int k=0; k<aircount; k++){
                                r=rand.nextInt(11);
                                r*=droncount;
                                solcount6-=r;
                            }
                            for(int k=0; k<navycount; k++){
                                r=rand.nextInt(16);
                                r*=droncount;
                                solcount6-=r;
                            }
                            editor6.putInt("soldierCount", solcount);

                        }
                    }
                }else{
                    //tero
                    if(idNation==i){
                        
                    }else{

                    }
                }
            }

        }
        //pieniądz musi się zgadzać :D
        int m1=sharedPreferences1.getInt("money", 0);
        int m2=sharedPreferences1.getInt("money", 0);
        int m3=sharedPreferences1.getInt("money", 0);
        int m4=sharedPreferences1.getInt("money", 0);
        int m5=sharedPreferences1.getInt("money", 0);
        int m6=sharedPreferences1.getInt("money", 0);
        int sol1=sharedPreferences1.getInt("soldierCount", 0);
        int sol2=sharedPreferences2.getInt("soldierCount", 0);
        int sol3=sharedPreferences3.getInt("soldierCount", 0);
        int sol4=sharedPreferences4.getInt("soldierCount", 0);
        int sol5=sharedPreferences5.getInt("soldierCount", 0);
        int sol6=sharedPreferences6.getInt("soldierCount", 0);
        int surc1=sharedPreferences1.getInt("surCount", 0);
        int surc2=sharedPreferences2.getInt("surCount", 0);
        int surc3=sharedPreferences3.getInt("surCount", 0);
        int surc4=sharedPreferences4.getInt("surCount", 0);
        int surc5=sharedPreferences5.getInt("surCount", 0);
        int surc6=sharedPreferences6.getInt("surCount", 0);
        int othc1=sharedPreferences1.getInt("otherCount", 0);
        int othc2=sharedPreferences2.getInt("otherCount", 0);
        int othc3=sharedPreferences3.getInt("otherCount", 0);
        int othc4=sharedPreferences4.getInt("otherCount", 0);
        int othc5 = sharedPreferences5.getInt("otherCount", 0);
        int othc6=sharedPreferences6.getInt("otherCount", 0);
        l1=sharedPreferences1.getBoolean("looser", true);
        l2=sharedPreferences2.getBoolean("looser", true);
        l3=sharedPreferences3.getBoolean("looser", true);
        l4=sharedPreferences4.getBoolean("looser", true);
        l5=sharedPreferences5.getBoolean("looser", true);
        l6=sharedPreferences6.getBoolean("looser", true);
        if(l1==false){
            d=m1+60*0.01*sol1+surc1*60+othc1*30;
            m1=d.intValue();
            editor1.putInt("money", m1);
            editor1.commit();
        }
        if(l2==false){
            d=m2+60*0.01*sol2+surc2*60+othc2*30;
            m2=d.intValue();
            editor2.putInt("money", m2);
            editor2.commit();
        }
        if(l3==false){
            d=m3+60*0.01*sol3+surc3*60+othc3*30;
            m3=d.intValue();
            editor3.putInt("money", m3);
            editor3.commit();
        }
        if(l4==false){
            d=m4+30*0.01*sol4+surc4*30+othc4*20;
            m4=d.intValue();
            editor4.putInt("money", m4);
            editor4.commit();
        }
        if(l5==false){
            d=m5+30*0.01*sol5+surc5*30+othc5*20;
            m5=d.intValue();
            editor5.putInt("money", m5);
            editor5.commit();
        }
        if(l6==false){
            d=m6+30*0.01*sol6+surc6*30+othc6*20;
            m6=d.intValue();
            editor6.putInt("money", m6);
            editor6.commit();
        }
        //sprawdzanie zwyciestwa
        Intent intent=new Intent(this, EndActivity.class);
        if(playerlooser==true){
            intent.putExtra("game", "YOU LOOSE");
            startActivity(intent);
        }
        double h4=sol4*0.01;
        double h5=sol5*0.01;
        double h6=sol6*0.01;

        if(l4==true&&l5==true&&l6==true){
            if(idNation<4){
                intent.putExtra("game", "YOU WIN");
                startActivity(intent);
            }else{
                intent.putExtra("game", "YOU LOOSE");
                startActivity(intent);
            }
        }
        if(h4>=100||h5>=100||h6>=100){
            if(idNation>3){
                intent.putExtra("game", "YOU WIN");
                startActivity(intent);
            }else{
                intent.putExtra("game", "YOU LOOSE");
                startActivity(intent);
            }
        }
    }

    public void exit(View view){
        System.exit(0);
    }
}
