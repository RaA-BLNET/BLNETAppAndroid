package com.blnet.blnettest.ui.register;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://tantegemmas.000webhostapp.com/androidlogin/register.php";
    private Map<String, String> params;

    public RegisterRequest(String vorname, String nachname, String email, String passwort, Response.Listener<String> listener){
        super (Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put ("vorname", vorname);
        params.put ("nachname", nachname);
        params.put ("email", email);
        params.put ("passwort", passwort);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
