package com.example.targon.tvsc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void goLogin(View view) {
        Intent intent=new Intent(this, InfoActivity.class);
        EditText editTextLogin=(EditText)findViewById(R.id.login);
        EditText editTextPassword=(EditText)findViewById(R.id.password);
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc", Context.MODE_PRIVATE);
        String loginText=editTextLogin.getText().toString();
        String logtest=sharedPreferences.getString(loginText, null);
        String passwordText=editTextPassword.getText().toString();
        if(passwordText.equals(logtest)){
            intent.putExtra("login",loginText);
            startActivity(intent);
        }else{
            TextView textViewAlert=(TextView)findViewById(R.id.alert);
            textViewAlert.setText("Wrong password or login");
        }
    }

    public void goReg(View view) {
        Intent intent=new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void exit(View view){
        System.exit(0);
    }
}
