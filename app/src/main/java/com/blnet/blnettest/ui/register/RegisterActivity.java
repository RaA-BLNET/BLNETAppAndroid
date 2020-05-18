package com.blnet.blnettest.ui.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.blnet.blnettest.R;
import com.blnet.blnettest.ui.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class RegisterActivity extends AppCompatActivity {

    Button regButton;
    EditText regVorname, regNachname, regEMail, regPasswort;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

                final EditText regVorname = (EditText) findViewById(R.id.regVorname);
                final EditText regNachname = (EditText) findViewById(R.id.regNachname);
                final EditText regEMail = (EditText) findViewById(R.id.regEMail);
                final EditText regPasswort = (EditText) findViewById(R.id.regPasswort);
                final Button regButton = (Button) findViewById(R.id.regButton);
                final ProgressBar loadingButton = findViewById(R.id.loadingRingReg);
                loadingButton.setVisibility(View.GONE);
                awesomeValidation = new AwesomeValidation(BASIC);
                awesomeValidation.addValidation(regVorname, "^(?=\\s*\\S).*$", getString(R.string.notempty));
                awesomeValidation.addValidation(regNachname, "^(?=\\s*\\S).*$", getString(R.string.notempty));
                awesomeValidation.addValidation(regEMail, "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", getString(R.string.validemail));
                awesomeValidation.addValidation(regPasswort, "^(?=\\s*\\S).{8,64}$", getString(R.string.passwordsec));
                regButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (awesomeValidation.validate()) {
                            loadingButton.setVisibility(View.VISIBLE);
                            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            final String vorname = regVorname.getText().toString();
                            final String nachname = regNachname.getText().toString();
                            final String email = regEMail.getText().toString();
                            final String passwort = regPasswort.getText().toString();


                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if (success == true) {
                                            loadingButton.setVisibility(View.GONE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                            Intent backintent = new Intent(RegisterActivity.this, LoginActivity.class);
                                            RegisterActivity.this.startActivity(backintent);
                                            Context context = getApplicationContext();
                                            CharSequence text = getString(R.string.regsuccess);
                                            int duration = Toast.LENGTH_LONG;
                                            Toast.makeText(context, text, duration).show();
                                        } else if (success == false) {
                                            loadingButton.setVisibility(View.GONE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                            builder.setTitle(getString(R.string.error))
                                                    .setMessage(getString(R.string.regfail))
                                                    .setNegativeButton(getString(R.string.tryagainlogin), null)
                                                    .create()
                                                    .show();
                                        }
                                    } catch (Exception e) {
                                        loadingButton.setVisibility(View.GONE);
                                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                        e.printStackTrace();
                                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                        builder.setTitle(getString(R.string.error))
                                                .setMessage(getString(R.string.jsonexceptreg))
                                                .setNegativeButton(getString(R.string.tryagainlogin), null)
                                                .create()
                                                .show();
                                    }
                                }
                            };

                            RegisterRequest registerRequest = new RegisterRequest(vorname, nachname, email, passwort, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                            queue.add(registerRequest);
                        }
                    }
        });
    }
}