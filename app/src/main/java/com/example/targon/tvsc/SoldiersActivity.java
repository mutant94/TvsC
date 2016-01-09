package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SoldiersActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;
    SharedPreferences sharedPreferencesPlayer;
    SharedPreferences.Editor editorPlayer;

    String txtbuysc="cost 10";
    String txtbuysc10="cost 10x10";
    String txtbuync="cost 200";
    String txtbuyac="cost 100";
    String txtbuydc="cost 5";
    String txtbuyst="cost 1";
    String txtbuyst10="cost 10x1";
    String txtbuynt="cost 10";
    String txtbuyat="cost 10";
    String txtbuydt="cost 500";
    String txtcbuy="can't buy";

    String login;
    int idNation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soldiers);
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
        TextView txtsol=(TextView)findViewById(R.id.txtsolcount);
        TextView txtnavy=(TextView)findViewById(R.id.txtnavycount);
        TextView txtair=(TextView)findViewById(R.id.txtaircount);
        TextView txtdron=(TextView)findViewById(R.id.txtdrocount);
        Button butsol=(Button)findViewById(R.id.butsol);
        Button butsol10=(Button)findViewById(R.id.butsol10);
        Button butair=(Button)findViewById(R.id.butair);
        Button butnavy=(Button)findViewById(R.id.butnavy);
        Button butdron=(Button)findViewById(R.id.butdro);
        ImageView imgnavy=(ImageView)findViewById(R.id.imgnavy);
        ImageView imgsol=(ImageView)findViewById(R.id.imgsol);
        ImageView imgair=(ImageView)findViewById(R.id.imgair);
        ImageView imgdron=(ImageView)findViewById(R.id.imgdro);
        int solcount=sharedPreferencesPlayer.getInt("soldierCount",-1);
        int navycount=sharedPreferencesPlayer.getInt("navyCount",-1);
        int droncount=sharedPreferencesPlayer.getInt("dronCount",-1);
        int aircount=sharedPreferencesPlayer.getInt("airCount",-1);

        butsol.setText(txtcbuy);
        butsol10.setText(txtcbuy);
        butair.setText(txtcbuy);
        butnavy.setText(txtcbuy);
        butdron.setText(txtcbuy);
        if(idNation>3){
            imgsol.setImageResource(R.drawable.solt);
            imgair.setImageResource(R.drawable.miat);
            imgnavy.setImageResource(R.drawable.mint);
            imgdron.setImageResource(R.drawable.radt);
            txtsol.setText("soldier- "+solcount);
            txtair.setText("airmissile- "+aircount);
            txtnavy.setText("navymissile- "+navycount);
            txtdron.setText("radar- "+droncount);
            if(money>=1){
                butsol.setText(txtbuyst);
                if(money>=10){
                    butsol10.setText(txtbuyst10);
                    butair.setText(txtbuyat);
                    butnavy.setText(txtbuynt);
                    if(money>=500){
                        butdron.setText(txtbuydt);
                    }
                }
            }
        }else{
            txtsol.setText("soldier- "+solcount);
            txtair.setText("aircraft- "+aircount);
            txtnavy.setText("ship- "+navycount);
            txtdron.setText("drone- "+droncount);
            if(money>=5){
                butdron.setText(txtbuydc);
                if(money>=10){
                    butsol.setText(txtbuysc);
                    if(money>=100){
                        butsol10.setText(txtbuysc10);
                        butair.setText(txtbuyac);
                        if(money>=200){
                            butnavy.setText(txtbuync);
                        }
                    }
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

    public void buysol(View view) {
        TextView txtsol=(TextView)findViewById(R.id.txtsolcount);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button butsol=(Button)findViewById(R.id.butsol);
        Button butsol10=(Button)findViewById(R.id.butsol10);
        Button butair=(Button)findViewById(R.id.butair);
        Button butnavy=(Button)findViewById(R.id.butnavy);
        Button butdron=(Button)findViewById(R.id.butdro);
        int solcount=sharedPreferencesPlayer.getInt("soldierCount",-1);
        int money=sharedPreferencesPlayer.getInt("money", -1);
        if(idNation>3){
            if(money>=1){
                editorPlayer.putInt("soldierCount", ++solcount);
                money=money-1;
                txtMoney.setText(""+money);
                editorPlayer.putInt("money", money);
                editorPlayer.commit();
                txtsol.setText("soldier- " + solcount);
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=1){
                    butsol.setText(txtbuyst);
                    if(money>=10){
                        butsol10.setText(txtbuyst10);
                        butair.setText(txtbuyat);
                        butnavy.setText(txtbuynt);
                        if(money>=500){
                            butdron.setText(txtbuydt);
                        }
                    }
                }
            }
        }else {
            if(money>=10){
                editorPlayer.putInt("soldierCount", ++solcount);
                money=money-10;
                txtMoney.setText(""+money);
                editorPlayer.putInt("money", money);
                editorPlayer.commit();
                txtsol.setText("soldier- " + solcount);
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=5){
                    butdron.setText(txtbuydc);
                    if(money>=10){
                        butsol.setText(txtbuysc);
                        if(money>=100){
                            butsol10.setText(txtbuysc10);
                            butair.setText(txtbuyac);
                            if(money>=200){
                                butnavy.setText(txtbuync);
                            }
                        }
                    }
                }
            }
        }
    }

    public void buysol10(View view) {
        TextView txtsol=(TextView)findViewById(R.id.txtsolcount);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button butsol=(Button)findViewById(R.id.butsol);
        Button butsol10=(Button)findViewById(R.id.butsol10);
        Button butair=(Button)findViewById(R.id.butair);
        Button butnavy=(Button)findViewById(R.id.butnavy);
        Button butdron=(Button)findViewById(R.id.butdro);
        int solcount=sharedPreferencesPlayer.getInt("soldierCount",-1);
        int money=sharedPreferencesPlayer.getInt("money", -1);
        if(idNation>3){
            if(money>=10){
                solcount+=10;
                editorPlayer.putInt("soldierCount", solcount);
                money=money-10;
                txtMoney.setText(""+money);
                editorPlayer.putInt("money", money);
                editorPlayer.commit();
                txtsol.setText("soldier- " + solcount);
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=1){
                    butsol.setText(txtbuyst);
                    if(money>=10){
                        butsol10.setText(txtbuyst10);
                        butair.setText(txtbuyat);
                        butnavy.setText(txtbuynt);
                        if(money>=500){
                            butdron.setText(txtbuydt);
                        }
                    }
                }
            }
        }else {
            if(money>=100){
                solcount+=10;
                editorPlayer.putInt("soldierCount", solcount);
                money=money-100;
                txtMoney.setText(""+money);
                editorPlayer.putInt("money", money);
                editorPlayer.commit();
                txtsol.setText("soldier- " + solcount);
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=5){
                    butdron.setText(txtbuydc);
                    if(money>=10){
                        butsol.setText(txtbuysc);
                        if(money>=100){
                            butsol10.setText(txtbuysc10);
                            butair.setText(txtbuyac);
                            if(money>=200){
                                butnavy.setText(txtbuync);
                            }
                        }
                    }
                }
            }
        }
    }

    public void buyair(View view) {
        TextView txtair=(TextView)findViewById(R.id.txtaircount);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button butsol=(Button)findViewById(R.id.butsol);
        Button butsol10=(Button)findViewById(R.id.butsol10);
        Button butair=(Button)findViewById(R.id.butair);
        Button butnavy=(Button)findViewById(R.id.butnavy);
        Button butdron=(Button)findViewById(R.id.butdro);
        int money=sharedPreferencesPlayer.getInt("money", -1);
        int aircount=sharedPreferencesPlayer.getInt("airCount",-1);
        if(idNation>3){
            if(money>=10){
                money=money-10;
                txtMoney.setText(""+money);
                editorPlayer.putInt("money", money);
                editorPlayer.putInt("airCount", ++aircount);
                txtair.setText("airmissile- " + aircount);
                editorPlayer.commit();
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=1){
                    butsol.setText(txtbuyst);
                    if(money>=10){
                        butsol10.setText(txtbuyst10);
                        butair.setText(txtbuyat);
                        butnavy.setText(txtbuynt);
                        if(money>=500){
                            butdron.setText(txtbuydt);
                        }
                    }
                }
            }

        }else{
            if(money>=100){
                money=money-100;
                txtMoney.setText(""+money);
                editorPlayer.putInt("money", money);
                editorPlayer.putInt("airCount", ++aircount);
                txtair.setText("plane- "+aircount);
                editorPlayer.commit();
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=5){
                    butdron.setText(txtbuydc);
                    if(money>=10){
                        butsol.setText(txtbuysc);
                        if(money>=100){
                            butsol10.setText(txtbuysc10);
                            butair.setText(txtbuyac);
                            if(money>=200){
                                butnavy.setText(txtbuync);
                            }
                        }
                    }
                }
            }
        }
    }

    public void buydron(View view) {
        TextView txtdron=(TextView)findViewById(R.id.txtdrocount);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button butsol=(Button)findViewById(R.id.butsol);
        Button butsol10=(Button)findViewById(R.id.butsol10);
        Button butair=(Button)findViewById(R.id.butair);
        Button butnavy=(Button)findViewById(R.id.butnavy);
        Button butdron=(Button)findViewById(R.id.butdro);
        int money=sharedPreferencesPlayer.getInt("money", -1);
        int droncount=sharedPreferencesPlayer.getInt("dronCount",-1);
        if(idNation>3){
            if(money>=500){
                money=money-500;
                editorPlayer.putInt("money", money);
                txtMoney.setText("" + money);
                editorPlayer.putInt("dronCount", ++droncount);
                txtdron.setText("radar- "+droncount);
                editorPlayer.commit();
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=1){
                    butsol.setText(txtbuyst);
                    if(money>=10){
                        butsol10.setText(txtbuyst10);
                        butair.setText(txtbuyat);
                        butnavy.setText(txtbuynt);
                        if(money>=500){
                            butdron.setText(txtbuydt);
                        }
                    }
                }
            }
        }else{
            if(money>=5){
                money=money-5;
                editorPlayer.putInt("money", money);
                txtMoney.setText("" + money);
                editorPlayer.putInt("dronCount", ++droncount);
                txtdron.setText("drone- " + droncount);
                editorPlayer.commit();
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=5){
                    butdron.setText(txtbuydc);
                   if(money>=10){
                    butsol.setText(txtbuysc);
                        if(money>=100){
                            butsol10.setText(txtbuysc10);
                            butair.setText(txtbuyac);
                            if(money>=200){
                                butnavy.setText(txtbuync);
                            }
                        }
                    }
                }
            }
        }
    }


    public void buynavy(View view) {
        TextView txtnavy=(TextView)findViewById(R.id.txtnavycount);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button butsol=(Button)findViewById(R.id.butsol);
        Button butsol10=(Button)findViewById(R.id.butsol10);
        Button butair=(Button)findViewById(R.id.butair);
        Button butnavy=(Button)findViewById(R.id.butnavy);
        Button butdron=(Button)findViewById(R.id.butdro);
        int money=sharedPreferencesPlayer.getInt("money", -1);
        int navycount=sharedPreferencesPlayer.getInt("navyCount",-1);
        if(idNation>3){
            if(money>=10){
                money=money-10;
                editorPlayer.putInt("money", money);
                txtMoney.setText("" + money);
                editorPlayer.putInt("navyCount", ++navycount);
                editorPlayer.commit();
                txtnavy.setText("navymissile- "+navycount);
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=1){
                    butsol.setText(txtbuyst);
                    if(money>=10){
                        butsol10.setText(txtbuyst10);
                        butair.setText(txtbuyat);
                        butnavy.setText(txtbuynt);
                        if(money>=500){
                            butdron.setText(txtbuydt);
                        }
                    }
                }
            }
        }else{
            if(money>=200){
                money=money-200;
                editorPlayer.putInt("money", money);
                txtMoney.setText("" + money);
                editorPlayer.putInt("navyCount", ++navycount);
                editorPlayer.commit();
                txtnavy.setText("ship- "+navycount);
                butsol.setText(txtcbuy);
                butsol10.setText(txtcbuy);
                butair.setText(txtcbuy);
                butnavy.setText(txtcbuy);
                butdron.setText(txtcbuy);
                if(money>=5){
                    butdron.setText(txtbuydc);
                    if(money>=10){
                        butsol.setText(txtbuysc);
                        if(money>=100){
                            butsol10.setText(txtbuysc10);
                            butair.setText(txtbuyac);
                            if(money>=200){
                                butnavy.setText(txtbuync);
                            }
                        }
                    }
                }
            }

        }
    }
}
