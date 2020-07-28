package com.med.shg_succor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.textfield.TextInputEditText;

public class Signuppre extends AppCompatActivity {
    //Initialze Variable
    TextInputEditText  groupname,username,email ,adhar ,address ,mobile ,otp ,password ,confirm_password;
    Button b1;
    TextView textView;

    AwesomeValidation awesomeValidation;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppre);

        textView= findViewById(R.id.condition);
        textView.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                Intent intent =new Intent(Signuppre.this,Loginpre.class);
                startActivity(intent);

            }
        });


        groupname = findViewById(R.id.Text_input_Group);
        username = findViewById(R.id.Text_input_username);
        email = findViewById(R.id.Text_input_email);
        adhar = findViewById(R.id.Text_input_adhar);
        address = findViewById(R.id.Text_input_place);
        mobile = findViewById(R.id.Text_input_mobile);
        otp = findViewById(R.id.Text_input_otp);
        password =findViewById(R.id.Text_input_password);
        confirm_password = findViewById(R.id.Text_input_Confirm_password);
        b1 = findViewById(R.id.btn_signup);

        //Initialize ValidationStyle
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Validation for Group name
        awesomeValidation.addValidation(this,R.id.Text_input_Group, RegexTemplate.NOT_EMPTY,R.string.invalid_group);

        awesomeValidation.addValidation(this,R.id.Text_input_name, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this,R.id.Text_input_email, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);

        awesomeValidation.addValidation(this,R.id.Text_input_adhar,"[12-16]{1}[0-16]{16}$",R.string.invalid_adhar);

        awesomeValidation.addValidation(this,R.id.Text_input_mobile,"[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);

        awesomeValidation.addValidation(this,R.id.Text_input_place, RegexTemplate.NOT_EMPTY,R.string.invalid_place);

        awesomeValidation.addValidation(this,R.id.Text_input_otp,"[5-9]{1}[0-9]{9}$",R.string.invalid_otp);

        awesomeValidation.addValidation(this,R.id.Text_input_password,".{6}",R.string.invalid_password);

        awesomeValidation.addValidation(this,R.id.Text_input_Confirm_password,R.id.Text_input_password,R.string.invalid_confirm_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check Validation
                if (awesomeValidation.validate()){
                    //On success
                    Intent intent = new Intent(Signuppre.this,Loginpre.class);
                    startActivity(intent);
                }
                else {Toast.makeText(getApplicationContext(),"Validation Failed.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}

