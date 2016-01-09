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

public class BaseActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String login;
    int idNation;
    String txtbt1="cost 300";
    String txtbt2="cost 200";
    String txtbc1="cost 600";
    String txtbc2="cost 300";
    String txtnotb="can't buy";
    SharedPreferences sharedPreferencesSystem;
    SharedPreferences.Editor editorSystem;
    SharedPreferences sharedPreferencesPlayer;
    SharedPreferences.Editor editorPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
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
        int countsur=sharedPreferencesPlayer.getInt("surCount", -1);
        int countoth=sharedPreferencesPlayer.getInt("otherCount", -1);
        TextView txt1=(TextView)findViewById(R.id.txtoil);
        TextView txt2=(TextView)findViewById(R.id.txtother);
        Button b1=(Button)findViewById(R.id.butoil);
        Button b2=(Button)findViewById(R.id.butother);
        if(idNation>3){
            ImageView img=(ImageView)findViewById(R.id.imgOther);
            img.setImageResource(R.drawable.terot);
            txt1.setText("Oil well-"+countsur+"(+"+countsur*30+")");
            txt2.setText("tero gr.-"+countoth+"(+"+countsur*20+")");
            if(money<200){
                b1.setText(txtnotb);
                b2.setText(txtnotb);
            }else if(money<300){
                b1.setText(txtnotb);
                b2.setText(txtbt2);
            }else{
                b1.setText(txtbt1);
                b2.setText(txtbt2);
            }
        }else{
            txt1.setText("Oil well-"+countsur+"(+"+countsur*60+")");
            txt2.setText("factory-"+countoth+"(+"+countsur*30+")");
            if(money<300){
                b1.setText(txtnotb);
                b2.setText(txtnotb);
            }else if(money<600){
                b1.setText(txtnotb);
                b2.setText(txtbc2);
            }else{
                b1.setText(txtbc1);
                b2.setText(txtbc2);
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

    public void buyBase1(View view) {
        int money=sharedPreferencesPlayer.getInt("money", -1);
        int countsur=sharedPreferencesPlayer.getInt("surCount", -1);
        TextView txt1=(TextView)findViewById(R.id.txtoil);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button b1=(Button)findViewById(R.id.butoil);
        Button b2=(Button)findViewById(R.id.butother);
        if(idNation>3){
            if(money>=300){
                money=money-300;
                editorPlayer.putInt("money", money);
                editorPlayer.putInt("surCount", ++countsur);
                editorPlayer.commit();
                txtMoney.setText(""+money);
                txt1.setText("Oil well-"+countsur+"(+"+countsur*30+")");
                if(money<200){
                    b1.setText(txtnotb);
                    b2.setText(txtnotb);
                }else if(money<300){
                    b1.setText(txtnotb);
                    b2.setText(txtbt2);
                }else{
                    b1.setText(txtbt1);
                    b2.setText(txtbt2);
                }
            }

        }else{
            if(money>=600){
                money=money-600;
                editorPlayer.putInt("money", money);
                editorPlayer.putInt("surCount", ++countsur);
                editorPlayer.commit();
                txtMoney.setText("" + money);
                txt1.setText("Oil well-"+countsur+"(+"+countsur*60+")");
                if(money<300){
                    b1.setText(txtnotb);
                    b2.setText(txtnotb);
                }else if(money<600){
                    b1.setText(txtnotb);
                    b2.setText(txtbc2);
                }else{
                    b1.setText(txtbc1);
                    b2.setText(txtbc2);
                }
            }
        }
    }

    public void buyBase2(View view) {
        int money=sharedPreferencesPlayer.getInt("money", -1);
        int countoth=sharedPreferencesPlayer.getInt("otherCount", -1);
        TextView txt2=(TextView)findViewById(R.id.txtother);
        TextView txtMoney=(TextView)findViewById(R.id.textmoney);
        Button b1=(Button)findViewById(R.id.butoil);
        Button b2=(Button)findViewById(R.id.butother);
        if(idNation>3){
            if(money>=200){
                money=money-200;
                editorPlayer.putInt("money", money);
                editorPlayer.putInt("surCount", ++countoth);
                editorPlayer.commit();
                txtMoney.setText(""+money);
                txt2.setText("tero gr.-"+countoth+"(+"+countoth*20+")");
                if(money<200){
                    b1.setText(txtnotb);
                    b2.setText(txtnotb);
                }else if(money<300){
                    b1.setText(txtnotb);
                    b2.setText(txtbt2);
                }else{
                    b1.setText(txtbt1);
                    b2.setText(txtbt2);
                }
            }
        }else {
            if(money>=300){
                money=money-300;
                editorPlayer.putInt("money", money);
                editorPlayer.putInt("surCount", ++countoth);
                editorPlayer.commit();
                txtMoney.setText(""+money);
                txt2.setText("factory-"+countoth+"(+"+countoth*30+")");
                if(money<300){
                    b1.setText(txtnotb);
                    b2.setText(txtnotb);
                }else if(money<600){
                    b1.setText(txtnotb);
                    b2.setText(txtbc2);
                }else{
                    b1.setText(txtbc1);
                    b2.setText(txtbc2);
                }
            }
        }
    }
}
