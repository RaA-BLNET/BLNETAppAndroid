package com.blnet.blnettest.ui.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.blnet.blnettest.R;
import com.blnet.blnettest.ui.MainActivity;
import com.blnet.blnettest.ui.pwreset.pwresetActivity;

import org.json.JSONObject;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class LoginActivity extends AppCompatActivity {
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText) findViewById(R.id.username);
        final EditText passwort = (EditText) findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button pwresetButton = findViewById(R.id.pwresetbtn);
        final ProgressBar loadingButton = findViewById(R.id.loading);
        awesomeValidation = new AwesomeValidation(BASIC);
        awesomeValidation.addValidation(email, "^(?=\\s*\\S).*$", getString(R.string.notempty));
        awesomeValidation.addValidation(passwort, "^(?=\\s*\\S).*$", getString(R.string.notempty));
        pwresetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, pwresetActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    loadingButton.setVisibility(View.VISIBLE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    final String username = email.getText().toString();
                    final String password = passwort.getText().toString();
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success == true) {
                                    loadingButton.setVisibility(View.GONE);
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    Intent backintent = new Intent(LoginActivity.this, MainActivity.class);
                                    LoginActivity.this.startActivity(backintent);
                                    Context context = getApplicationContext();
                                    String vorname = jsonResponse.getString("vorname");
                                    String nachname = jsonResponse.getString("nachname");
                                    String email = jsonResponse.getString("email");
                                    // saving login credentials
                                    SharedPreferences spLogin = getSharedPreferences("loggedinuser", MODE_PRIVATE);
                                    // saving vorname + nachname
                                    SharedPreferences.Editor editor = getSharedPreferences("loggedinuser", MODE_PRIVATE).edit();
                                    editor.putString("vorname", vorname);
                                    editor.apply();
                                    editor = getSharedPreferences("loggedinuser", MODE_PRIVATE).edit();
                                    editor.putString("nachname", nachname);
                                    editor.apply();
                                    // saving email
                                    editor = getSharedPreferences("loggedinuser", MODE_PRIVATE).edit();
                                    editor.putString("email", email);
                                    editor.apply();
                                    // toast login confirmation
                                    CharSequence text = getString(R.string.welcome) + " " + vorname + " " + nachname;
                                    int duration = Toast.LENGTH_LONG;
                                    Toast.makeText(context, text, duration).show();
                                } else {
                                    loadingButton.setVisibility(View.GONE);
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setTitle(getString(R.string.error))
                                            .setMessage(getString(R.string.login_failed))
                                            .setNegativeButton(getString(R.string.tryagainlogin), null)
                                            .create()
                                            .show();
                                }
                            } catch (Exception e) {
                                loadingButton.setVisibility(View.GONE);
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                e.printStackTrace();
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setTitle(getString(R.string.error))
                                        .setMessage(getString(R.string.jsonexceptlogin))
                                        .setNegativeButton(getString(R.string.tryagainlogin), null)
                                        .create()
                                        .show();
                            }
                        }
                    };


                    LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);
                }
            }
        });

        SharedPreferences spLogin = getSharedPreferences("loggedinuser", MODE_PRIVATE);
        final String emailiden = spLogin.getString("email", null);
        email.setText(emailiden);

    }
}