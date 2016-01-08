package com.example.targon.tvsc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void musicPlay(View view) {
        //zmiana icony
        ImageView img=(ImageView)findViewById(R.id.imgPlayMusic);
        //img.setImageResource(R.drawable.moff);
        //img.setImageResource(R.drawable.mon);
    }
}
