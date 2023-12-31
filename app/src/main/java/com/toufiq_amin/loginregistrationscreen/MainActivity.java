package com.toufiq_amin.loginregistrationscreen;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addListenerOnButtonClick();

    }
    private void addListenerOnButtonClick() {

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // moving to login screen
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                //close activity
                //finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // moving to register screen
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
                //close activity
                //finish();
            }
        });
    }

}


