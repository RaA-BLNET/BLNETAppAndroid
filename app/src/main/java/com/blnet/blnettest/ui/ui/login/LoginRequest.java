package com.blnet.blnettest.ui.ui.login;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "https://tantegemmas.000webhostapp.com/androidlogin/login.php";
    private Map<String, String> params;

    public LoginRequest(String email, String passwort, Response.Listener<String> listener){
        super (Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put ("email", email);
        params.put ("passwort", passwort);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}