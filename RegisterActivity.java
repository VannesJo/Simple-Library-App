package com.example.perpusonline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.perpusonline.Database.User;

import java.util.Calendar;


public class RegisterActivity extends AppCompatActivity {

    public static int userCounter= 0;

    TextView text;
    EditText RegEmail, RegPass, RegPhone;
    CheckBox RegTerm;
    Button FinalReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //findview
        text = findViewById(R.id.RegDOB);
        RegEmail = findViewById(R.id.RegEmail);
        RegPass = findViewById(R.id.RegPass);
        RegPhone = findViewById(R.id.RegPhone);
        RegTerm = findViewById(R.id.RegTerm);
        FinalReg = findViewById(R.id.FinalReg);

        //Buat pilih tanggal
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        text.setText(i + "/" + (i1 + 1) + "/" + i2);
                    }
                };
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this,
                        onDateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                        );
                datePickerDialog.show();
            }
        });


        //validasi register
        FinalReg.setOnClickListener(view -> {
            String email, password, phoneNum, dob;

            email = RegEmail.getText().toString();
            password = RegPass.getText().toString();
            phoneNum = RegPhone.getText().toString();
            dob = text.getText().toString();

            //validation
            if(email.isEmpty() || password.isEmpty() || phoneNum.isEmpty() || dob.isEmpty() ||dob.equals("Select DOB")) {
                Toast.makeText(RegisterActivity.this, "Please fill all requirements!", Toast.LENGTH_SHORT).show();
            }

            else if(password.length() < 9){
                Toast.makeText(RegisterActivity.this, "Password min 9 characters!", Toast.LENGTH_SHORT).show();
            }

            else if(!password.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*")){
                Toast.makeText(RegisterActivity.this, "Password must have a letter and digit!", Toast.LENGTH_SHORT).show();
            }

            else if(phoneNum.indexOf("+62") != 0){
                Toast.makeText(RegisterActivity.this, "Phone number starts with +62!", Toast.LENGTH_SHORT).show();
            }

            else if(phoneNum.length() <10 || phoneNum.length() >15){
                Toast.makeText(RegisterActivity.this, "Phone number between 10-15 inclusive!", Toast.LENGTH_SHORT).show();
            }

            else if(!RegTerm.isChecked()){
                Toast.makeText(RegisterActivity.this, "Please check the terms and conditions!", Toast.LENGTH_SHORT).show();
            }

            else {
                userCounter++;
                User.userID.add(userCounter);
                User.email.add(email);
                User.password.add(password);
                User.dob.add(dob);
                User.phoneNum.add(phoneNum);

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}