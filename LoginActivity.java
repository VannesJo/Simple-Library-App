package com.example.perpusonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.perpusonline.Database.User;

public class LoginActivity extends AppCompatActivity {

public static int currUser = 0;
    TextView Register_Btn;
    Button Login_Btn;
    EditText Login_Email, Login_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login_Btn = findViewById(R.id.LoginBtn);
        Register_Btn = findViewById(R.id.RegisterBtn);
        Login_Email = findViewById(R.id.LoginEmail);
        Login_Pass = findViewById(R.id.LoginPass);

        //validasi login
        Login_Btn.setOnClickListener(view -> {
            String emailVal, emailVal2, passwordVal, passwordVal2;

            if(!User.userID.isEmpty()) {
                int id = (RegisterActivity.userCounter);
                id--;

                emailVal = Login_Email.getText().toString();
                emailVal2 = User.email.get(id);
                passwordVal = Login_Pass.getText().toString();
                passwordVal2 = User.password.get(id);

                if( (emailVal.equals(emailVal2)) && (passwordVal.equals(passwordVal2)) ){
                    int finalId = id;
                    currUser = User.userID.get(finalId);

                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }

                else{
                    Toast.makeText(LoginActivity.this, "Email or Password is invalid!", Toast.LENGTH_SHORT).show();
                }

            }

            if(User.userID.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please register first!", Toast.LENGTH_SHORT).show();
            }

        });



        Register_Btn.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        });
    }
}