package com.blnet.blnettest.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.blnet.blnettest.R;
import com.blnet.blnettest.ui.ui.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    Button regButton;
    EditText regVorname, regNachname, regEMail, regPasswort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

                final EditText regVorname = (EditText) findViewById(R.id.regVorname);
                final EditText regNachname = (EditText) findViewById(R.id.regNachname);
                final EditText regEMail = (EditText) findViewById(R.id.regEMail);
                final EditText regPasswort = (EditText) findViewById(R.id.regPasswort);
                final Button regButton = (Button) findViewById(R.id.regButton);

                regButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String vorname = regVorname.getText().toString();
                        final String nachname = regNachname.getText().toString();
                        final String email = regEMail.getText().toString();
                        final String passwort = regPasswort.getText().toString();

                        Response.Listener<String> responseListener = new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response) {
                                try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success == true) {
                                        Intent backintent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        RegisterActivity.this.startActivity(backintent);
                                } else if (success == false){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("Registration fehlgeschlagen")
                                            .setNegativeButton("Erneut versuchen", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };

                        RegisterRequest registerRequest = new RegisterRequest(vorname, nachname, email, passwort, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                        queue.add(registerRequest);
                    }
        });
    }
}