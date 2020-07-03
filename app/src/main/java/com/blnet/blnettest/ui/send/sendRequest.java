package com.blnet.blnettest.ui.send;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class sendRequest extends StringRequest {

    private static final String LINK_REQUEST_URL = "https://app.blnet.ch/scripts/noteformauth.php";
    private Map<String, String> params;

    public sendRequest(String email, Response.Listener<String> listener){
        super (Request.Method.POST, LINK_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put ("email", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
