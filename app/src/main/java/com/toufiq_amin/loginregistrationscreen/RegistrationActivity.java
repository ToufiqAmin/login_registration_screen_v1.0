package com.toufiq_amin.loginregistrationscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {


    private EditText user_name, mobile, password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        user_name = findViewById(R.id.user_name);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkDataEntered();
//                boolean result = checkDataEntered();
//
//                if (result==true)
//                {
//                    Toast t = Toast.makeText(getApplicationContext(),"Registration Successful",
//                            Toast.LENGTH_LONG);
//                    Intent i = new Intent(RegistrationActivity.this,
//                            LoginActivity.class);
//                    startActivity(i);
//                    t.show();
//                }
            }
        });
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
        String phone = mobile.getText().toString().trim();
        if (isEmpty(user_name)){
            user_name.setError("User Name is required!");
        } else if (isEmpty(mobile)) {
            mobile.setError("Mobile Number is required!");
        }else if(isEmpty(password)){
            password.setError("Password is required!");
            //return false;
        }
        //else return true;
        else {

            if (Patterns.PHONE.matcher(phone).matches()) {
                Toast t = Toast.makeText(getApplicationContext(),"Registration Successful",
                            Toast.LENGTH_LONG);
                    Intent i = new Intent(RegistrationActivity.this,
                            LoginActivity.class);
                    startActivity(i);
                    t.show();
            }
            else {
                mobile.setError("Mobile Number is invalid!");
            }
        }
    };
}