package com.example.targon.tvsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Registration3Activity extends AppCompatActivity {
    String login;
    int addid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration3);
        getSupportActionBar().hide();
        Intent i=getIntent();
        login=i.getStringExtra("login");
        int id=i.getIntExtra("id", 0);
        TextView txt1=(TextView)findViewById(R.id.txt1);
        TextView txt2=(TextView)findViewById(R.id.txt2);
        TextView txt3=(TextView)findViewById(R.id.txt3);
        ImageView img1=(ImageView)findViewById(R.id.img1);
        ImageView img2=(ImageView)findViewById(R.id.img2);
        ImageView img3=(ImageView)findViewById(R.id.img3);
        if(id==1){
            txt1.setText("USA (+3 oil wells)");
            txt2.setText("Russia (+2500 soldiers)");
            txt3.setText("EU (+10 special points from the start and +20 spec. points every round)");
            addid=0;
        }
        if(id==2){
            img1.setImageResource(R.drawable.isisflag);
            img2.setImageResource(R.drawable.bohaflag);
            img3.setImageResource(R.drawable.alshflag);
            txt1.setText("ISIS (+3 oil wells)");
            txt2.setText("Boko Haram (+10 special points from the start and +20 spec. points every round)");
            txt3.setText("Al Shabat (+2500 soldiers)");
            addid=3;
        }



    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void goReg41(View view) {
        Intent intent=new Intent(this, Registration4Activity.class);
        intent.putExtra("login", login);
        int id=1 + addid;
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void goReg42(View view) {
        Intent intent=new Intent(this, Registration4Activity.class);
        intent.putExtra("login", login);
        int id=2 + addid;
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void goReg43(View view) {
        Intent intent=new Intent(this, Registration4Activity.class);
        intent.putExtra("login", login);
        int id=3 + addid;
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
