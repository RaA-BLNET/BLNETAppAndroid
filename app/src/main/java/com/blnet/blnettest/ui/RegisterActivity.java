package com.blnet.blnettest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blnet.blnettest.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Button regButton;
    EditText regVorname, regNachname, regEMail, regPasswort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

                regVorname = (EditText) findViewById(R.id.regVorname);
                regNachname = (EditText) findViewById(R.id.regNachname);
                regEMail = (EditText) findViewById(R.id.regEMail);
                regPasswort = (EditText) findViewById(R.id.regPasswort);
                regButton = (Button) findViewById(R.id.regButton);

                regButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regButton:

                break;
        }
    }
}