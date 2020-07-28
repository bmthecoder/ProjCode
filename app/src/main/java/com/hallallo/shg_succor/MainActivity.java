package com.med.shg_succor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLanguage;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hallallo.shg_succor.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner CustomSpinner;
    private Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b2 = findViewById(R.id.btn_president);
        b3 = findViewById(R.id.btn_member);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this,login_p.class);
                startActivity(int2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(MainActivity.this,Loginmem.class);
                startActivity(int3);
            }
        });
        CustomSpinner =findViewById(R.id.CustomSpinner);

        ArrayList<CustomsItems>customList=new ArrayList<>();
        customList.add(new CustomsItems("ENGLISH"));
        customList.add(new CustomsItems("TAMIL_தமிழ்"));
        customList.add(new CustomsItems("HINDHI_हिन्दी"));
        customList.add(new CustomsItems("MARATHI_मारथी"));
        customList.add(new CustomsItems("GUJARATI_ગુજરાતી"));


        CustomAdapter customAdapter = new CustomAdapter(this,customList);

        if (CustomSpinner != null){
            CustomSpinner.setAdapter(customAdapter);
            CustomSpinner.setOnItemSelectedListener(this);

        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AdapterView adapterView = null;
        CustomsItems items = (CustomsItems) adapterView. getSelectedItem();
        final Toast toast;
        //toast = Toast.makeText(MainActivity.this,
        // items.getSpinnerText();
        // Toast.LENGTH_LONG.show());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

