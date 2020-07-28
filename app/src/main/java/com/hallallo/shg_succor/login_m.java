package com.med.shg_succor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.textfield.TextInputEditText;
import com.hallallo.shg_succor.R;

public class Loginmem extends AppCompatActivity {

    TextInputEditText username , email,conform_password ;
    Button b1;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmem);

        username = findViewById(R.id.Text_input_name);
        email = findViewById(R.id.Text_input_email);
        conform_password =findViewById(R.id.Text_input_password);

        //Initialize ValidationStyle
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.Text_input_name, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this,R.id.Text_input_email, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);

        awesomeValidation.addValidation(this,R.id.Text_input_password,".{6}", R.string.invalid_password);

        b1 = findViewById(R.id.btn_signup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check Validation
                if (awesomeValidation.validate()){
                    //On success
                    Intent int1 = new Intent(Loginmem.this,signup.class);
                    startActivity(int1);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Validation Failed.",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }}

