package com.blnet.blnettest.ui.pwreset;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.blnet.blnettest.R;
import com.blnet.blnettest.ui.MainActivity;
import com.blnet.blnettest.ui.login.LoginActivity;
import com.blnet.blnettest.ui.login.LoginRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class pwresetActivity extends AppCompatActivity {
    private AwesomeValidation awesomeValidation;
    private Boolean successlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwreset);
        // XML Elemente holen
        final EditText rstemail = (EditText) findViewById(R.id.rstemail);
        final EditText rstoldpass = (EditText) findViewById(R.id.rstoldpassword);
        final EditText rstnewpass = (EditText) findViewById(R.id.rstnewpassword);
        final EditText rstnewpassconf = (EditText) findViewById(R.id.rstnewpasswordconf);
        final Button rstButton = (Button) findViewById(R.id.rstbutton);
        final ProgressBar loadingButton = (ProgressBar) findViewById(R.id.loadingpwr);
        // Textfeld Validierung
        awesomeValidation = new AwesomeValidation(BASIC);
        awesomeValidation.addValidation(rstemail, "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", getString(R.string.validemail));
        awesomeValidation.addValidation(rstoldpass, "^(?=\\s*\\S).*$", getString(R.string.notempty));
        awesomeValidation.addValidation(rstnewpass,  "^(?=\\s*\\S).{8,64}$", getString(R.string.passwordsec));
        if (!rstnewpass.equals(rstnewpassconf)) {
            awesomeValidation.addValidation(rstnewpassconf,  "^(?=\\s*\\S).{8,64}$", getString(R.string.pwnotequal));
        }
        rstButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    final String rstemailstr = rstemail.getText().toString();
                    final String rstoldpassstr = rstoldpass.getText().toString();
                    final String rstnewpassstr = rstnewpass.getText().toString();
                    loadingButton.setVisibility(View.VISIBLE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                successlogin = jsonResponse.getBoolean("success");
                                if (successlogin == true) {
                                    loadingButton.setVisibility(View.GONE);
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    RequestQueue queue = Volley.newRequestQueue(pwresetActivity.this);
                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://app.blnet.ch/scripts/resetpass.php", new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            loadingButton.setVisibility(View.GONE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                            CharSequence toasttext = getString(R.string.successchange);
                                            int duration = Toast.LENGTH_LONG;
                                            Toast successinfo = Toast.makeText(pwresetActivity.this, toasttext, duration);
                                            successinfo.show();
                                            Intent backToMain = new Intent(pwresetActivity.this, LoginActivity.class);
                                            startActivity(backToMain);
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            loadingButton.setVisibility(View.GONE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                            AlertDialog.Builder builder = new AlertDialog.Builder(pwresetActivity.this);
                                            builder.setTitle(getString(R.string.error))
                                                    .setMessage(getString(R.string.neterror))
                                                    .setNegativeButton(getString(R.string.tryagainlogin), null)
                                                    .create()
                                                    .show();
                                        }
                                    }) {
                                        protected Map<String, String> getParams() {
                                            Map<String, String> params = new HashMap<String, String>();
                                            params.put("email", rstemailstr);
                                            params.put("newpassword", rstnewpassstr);
                                            return params;
                                        }

                                        @Override
                                        public Map<String, String> getHeaders() throws AuthFailureError {
                                            Map<String, String> params = new HashMap<String, String>();
                                            params.put("Content-Type", "application/x-www-form-urlencoded");
                                            return params;
                                        }
                                    };
                                    queue.add(stringRequest);
                                } else {
                                    loadingButton.setVisibility(View.GONE);
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(pwresetActivity.this);
                                    builder.setTitle(getString(R.string.error))
                                            .setMessage(getString(R.string.wrongemailoldpwd))
                                            .setNegativeButton(getString(R.string.tryagainlogin), null)
                                            .create()
                                            .show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    LoginRequest loginRequest = new LoginRequest(rstemailstr, rstoldpassstr, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(pwresetActivity.this);
                    queue.add(loginRequest);

                }
            }
        });
    }
}
