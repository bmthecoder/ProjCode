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

public class Loginpre extends AppCompatActivity {

    TextInputEditText mobile,otp ;
    Button b1,b2;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpre);

        mobile = findViewById(R.id.Text_input_mobile);
        otp= findViewById(R.id.Text_input_OTP);

        //Initialize ValidationStyle
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.Text_input_mobile, RegexTemplate.NOT_EMPTY,R.string.invalid_mobile);

        awesomeValidation.addValidation(this, R.id.Text_input_OTP, Patterns.EMAIL_ADDRESS,R.string.invalid_otp);

        b2 = findViewById(R.id.btn_signup);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check Validation
                if (awesomeValidation.validate()){
                    //On success
                    Intent int1 = new Intent(Loginpre.this,signup.class);
                    startActivity(int1);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Validation Failed.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}

