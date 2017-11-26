package com.example.ee.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        final EditText etusername = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.btn_lgn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etusername.getText().toString();
                String password = etPassword.getText().toString();
                if (username.equals("kawe")&&password.equals("kawe")) {
                    Toast.makeText(getApplicationContext(), "Anda Berhasil Login", Toast.LENGTH_SHORT).show();
                    Intent LgnIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(LgnIntent);
                } else if (username.matches("")||password.matches("")){
                    Toast.makeText(getApplicationContext(),"Username dan Password tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(),"username dan Password tidak sesuai",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}