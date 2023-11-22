package com.toufiq_amin.loginregistrationscreen;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mobile, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
        String phone = mobile.getText().toString().trim();
        if (isEmpty(mobile)){
            mobile.setError("Phone Number is required!");
        } else if (isEmpty(password)) {
            password.setError("Password is required!");
        }
        {

            if (Patterns.PHONE.matcher(phone).matches()) {
                Toast t = Toast.makeText(getApplicationContext(),"Login Successful",
                        Toast.LENGTH_LONG);
                Intent i = new Intent(LoginActivity.this,
                        DashBoardActivity.class);
                startActivity(i);
                t.show();
            }
            else {
                mobile.setError("Mobile Number is invalid!");
            }
        }
    };

}