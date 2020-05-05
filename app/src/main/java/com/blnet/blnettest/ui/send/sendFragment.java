package com.blnet.blnettest.ui.send;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import android.widget.Button;


import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blnet.blnettest.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.blnet.blnettest.ui.MainActivity;
import com.blnet.blnettest.ui.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;
import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class sendFragment extends Fragment implements View.OnClickListener {

    private sendViewModel sendViewModel;
    private EditText editDatum, errorSpinner, editThema, editNote, begrSend;
    private TextView descSend1, descSend2, descSend3, descSend4, descSend5, descSend6, descSend7;
    private Spinner dropFach;
    private RadioGroup radioType;
    private Button submitButton, noteformButton;
    private RadioButton notea;
    private ProgressBar loadingButton;

    private AwesomeValidation awesomeValidation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assert getFragmentManager() != null;
        sendViewModel =
                ViewModelProviders.of(this).get(sendViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_send, container, false);
        SharedPreferences spLogin = Objects.requireNonNull(this.getActivity()).getSharedPreferences("loggedinuser", MODE_PRIVATE);
        final String emailiden = spLogin.getString("email", "");
        final String nachname = spLogin.getString("nachname", "");
        final TextView titleSend = root.findViewById(R.id.text_send);
        awesomeValidation = new AwesomeValidation(BASIC);
        editDatum = (EditText) root.findViewById(R.id.dateSend);
        dropFach = (Spinner) root.findViewById(R.id.fachSend);
        errorSpinner = (EditText) root.findViewById(R.id.errorSpinner);
        editThema = (EditText) root.findViewById(R.id.themaSend);
        radioType = (RadioGroup) root.findViewById(R.id.typeSend);
        notea = (RadioButton) root.findViewById(R.id.notea);
        editNote = (EditText) root.findViewById(R.id.noteSend);
        begrSend = (EditText) root.findViewById(R.id.begrSend);
        descSend1 = (TextView) root.findViewById(R.id.descSend1);
        descSend2 = (TextView) root.findViewById(R.id.descSend2);
        descSend3 = (TextView) root.findViewById(R.id.descSend3);
        descSend4 = (TextView) root.findViewById(R.id.descSend4);
        descSend5 = (TextView) root.findViewById(R.id.descSend5);
        descSend6 = (TextView) root.findViewById(R.id.descSend6);
        descSend7 = (TextView) root.findViewById(R.id.descSend7);

        submitButton = (Button) root.findViewById(R.id.submit);
        noteformButton = (Button) root.findViewById(R.id.notetab);
        loadingButton = (ProgressBar) root.findViewById(R.id.loadingRing);
        loadingButton.setVisibility(View.GONE);
        submitButton.setOnClickListener(this);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    final String tempEmailjson = jsonResponse.getString("email");
                    final String sheetlinkjson = jsonResponse.getString("sheetlink");
                    final String scriptlinkjson = jsonResponse.getString("scriptlink");
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("noteform", MODE_PRIVATE).edit();
                    editor.putString("tempMail", tempEmailjson);
                    editor.apply();
                    editor.putString("sheetlink", sheetlinkjson);
                    editor.apply();
                    editor.putString("scriptlink", scriptlinkjson);
                    editor.apply();
                    if (success == true) {
                        titleSend.setText(getString(R.string.concatnoteformtitle) + " " + nachname);
                    } else if (success == false) {
                        titleSend.setText(getString(R.string.norights));
                        editDatum.setVisibility(View.GONE);
                        dropFach.setVisibility(View.GONE);
                        errorSpinner.setVisibility(View.GONE);
                        editThema.setVisibility(View.GONE);
                        radioType.setVisibility(View.GONE);
                        notea.setVisibility(View.GONE);
                        begrSend.setVisibility(View.GONE);
                        editNote.setVisibility(View.GONE);
                        descSend1.setVisibility(View.GONE);
                        descSend2.setVisibility(View.GONE);
                        descSend3.setVisibility(View.GONE);
                        descSend4.setVisibility(View.GONE);
                        descSend5.setVisibility(View.GONE);
                        descSend6.setVisibility(View.GONE);
                        descSend7.setVisibility(View.GONE);
                        submitButton.setVisibility(View.GONE);
                        noteformButton.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    titleSend.setText(getString(R.string.jsonexceptsend));
                    editDatum.setVisibility(View.GONE);
                    dropFach.setVisibility(View.GONE);
                    errorSpinner.setVisibility(View.GONE);
                    editThema.setVisibility(View.GONE);
                    radioType.setVisibility(View.GONE);
                    notea.setVisibility(View.GONE);
                    begrSend.setVisibility(View.GONE);
                    editNote.setVisibility(View.GONE);
                    descSend1.setVisibility(View.GONE);
                    descSend2.setVisibility(View.GONE);
                    descSend3.setVisibility(View.GONE);
                    descSend4.setVisibility(View.GONE);
                    descSend5.setVisibility(View.GONE);
                    descSend6.setVisibility(View.GONE);
                    descSend7.setVisibility(View.GONE);
                    submitButton.setVisibility(View.GONE);
                    noteformButton.setVisibility(View.GONE);
                }
            }
        };
        sendRequest sendRequest = new sendRequest(emailiden, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(sendRequest);
        SharedPreferences spNote = getActivity().getSharedPreferences("noteform", MODE_PRIVATE);
        final String tempEmail =  spNote.getString("email", null);
        final String sheetlink = spNote.getString("sheetlink", null);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                 if (emailiden.equals("")) {
                    titleSend.setText(getString(R.string.nouser));
                    editDatum.setVisibility(View.GONE);
                    dropFach.setVisibility(View.GONE);
                    errorSpinner.setVisibility(View.GONE);
                    editThema.setVisibility(View.GONE);
                    radioType.setVisibility(View.GONE);
                    notea.setVisibility(View.GONE);
                    begrSend.setVisibility(View.GONE);
                    editNote.setVisibility(View.GONE);
                    descSend1.setVisibility(View.GONE);
                    descSend2.setVisibility(View.GONE);
                    descSend3.setVisibility(View.GONE);
                    descSend4.setVisibility(View.GONE);
                    descSend5.setVisibility(View.GONE);
                    descSend6.setVisibility(View.GONE);
                    descSend7.setVisibility(View.GONE);
                    submitButton.setVisibility(View.GONE);
                    noteformButton.setVisibility(View.GONE);
                }
            }
        });
        Spinner spinner = (Spinner) root.findViewById(R.id.fachSend);
        String[] values = getResources().getStringArray(R.array.noten);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        Button notetabsend = (Button) root.findViewById(R.id.notetab);
        notetabsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(sheetlink.trim()));
                startActivity(browserIntent);
            }
        });
        awesomeValidation.addValidation(editDatum, "([0-9]{2}\\.){0,2}([0-9]{4})", getString(R.string.dateerror));
        awesomeValidation.addValidation(editThema, "^(?=\\s*\\S).*$", getString(R.string.themaerror));
        awesomeValidation.addValidation(editNote, "[0-9]+(\\.[0-9]+)?", getString(R.string.noteerror));
        if (!editNote.getText().toString().isEmpty()) {
            float inputNote = Float.parseFloat(editNote.getText().toString().trim());
            if (inputNote < 4.0) {
                awesomeValidation.addValidation(begrSend, "^(?=\\s*\\S).*$", getString(R.string.begrerror));
            }
        }


        submitButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View root) {
            if (dropFach.getSelectedItem().toString().trim().equals("Bitte auswählen*")) {
                errorSpinner.setError(getString(R.string.facherror));
            } else {
                errorSpinner.setError(null);
            }
            if (radioType.getCheckedRadioButtonId()<=0){
                notea.setError(getString(R.string.notetypeerror));
            } else {
                notea.setError(null);
            }
        }
        });
        submitButton.setOnClickListener(this);
        return root;
    }
    private void submitForm() {
        if (awesomeValidation.validate()) {
            // Notenformular abschicken
            loadingButton.setVisibility(View.VISIBLE);
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            final String date = editDatum.getText().toString();
            final String subject = dropFach.getSelectedItem().toString();
            final String thema = editThema.getText().toString();
            final int notetypepre = radioType.getCheckedRadioButtonId();
            RadioButton notetypeSelected = (RadioButton) getActivity().findViewById(notetypepre);
            final String notetype = notetypeSelected.getText().toString();
            final String note = editNote.getText().toString();
            final String begr = begrSend.getText().toString();
            SharedPreferences spNote = getActivity().getSharedPreferences("noteform", MODE_PRIVATE);
            final String scriptlink = spNote.getString("scriptlink", null);
            RequestQueue queue = Volley.newRequestQueue(getContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, scriptlink, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    loadingButton.setVisibility(View.GONE);
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    CharSequence toasttext = getString(R.string.successsend);
                    int duration = Toast.LENGTH_LONG;
                    Toast successinfo = Toast.makeText(getContext(), toasttext, duration);
                    successinfo.show();
                    Intent backToMain = new Intent(getActivity(), MainActivity.class);
                    startActivity(backToMain);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    loadingButton.setVisibility(View.GONE);
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(getString(R.string.error))
                            .setMessage(getString(R.string.notefail))
                            .setNegativeButton(getString(R.string.tryagainlogin), null)
                            .create()
                            .show();
                }
            }) {
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("action", "addItem");
                    params.put("datum", date);
                    params.put("fach", subject);
                    params.put("themaPruefung", thema);
                    params.put("notenTyp", notetype);
                    params.put("note", note);
                    params.put("begruendung", begr);
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
        }
    }
    public void onClick(View root) {
        if (root == submitButton) {
            submitForm();
        }
    }
}
