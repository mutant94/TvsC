package com.example.targon.tvsc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void nextRegi1(View view) {
        EditText elogin=(EditText)findViewById(R.id.editLogin);
        EditText epass=(EditText)findViewById(R.id.editPassword);
        EditText epass2=(EditText)findViewById(R.id.editPassword2);
        TextView alertlog=(TextView)findViewById(R.id.alertRegiLogin);
        TextView alertpass=(TextView)findViewById(R.id.alertRegiPass);
        Intent intent=new Intent(this, Registration2Activity.class);
        String login= elogin.getText().toString();
        String password= epass.getText().toString();
        String password2= epass2.getText().toString();
        alertpass.setText("");
        alertlog.setText("");
        sharedPreferences=getSharedPreferences("com.example.targon.tvsc", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

        String logtest=sharedPreferences.getString(login, "");

        if(logtest.equals("")) {
            if (password.equals(password2)&&!password.equals("")) {
                editor.putString(login, password);
                editor.commit();
                intent.putExtra("login", login);
                startActivity(intent);

            } else {
                alertpass.setText("Passwords are not equal!");
            }

        }else {
            alertlog.setText("This login is already in use!");
        }
    }
}
