package com.blnet.blnettest.ui.send;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.blnet.blnettest.R;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class sendFragment extends Fragment {

    private sendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assert getFragmentManager() != null;
        sendViewModel =
                ViewModelProviders.of(this).get(sendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        SharedPreferences spLogin = Objects.requireNonNull(this.getActivity()).getSharedPreferences("loggedinuser", MODE_PRIVATE);
        final String emailiden = spLogin.getString("email", "");
        final TextView titleSend = root.findViewById(R.id.text_send);

        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (emailiden.equals("alessandro.basile@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Basile");
                } else if (emailiden.equals("till.gasser@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Gasser");
                } else if (emailiden.equals("ian.hild@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Hild");
                } else if (emailiden.equals("nicola.pettikoffer@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Pettikoffer");
                } else if (emailiden.equals("a.rahunenthiran@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Rahunenthiran");
                } else if (emailiden.equals("valdrin.useini@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Useini");
                } else if (emailiden.equals("noel.wangler@bbz-sh.ch")) {
                    titleSend.setText("Notenformular Wangler");
                } else if (emailiden.equals("")) {
                    titleSend.setText("Sie müssen sich anmelden und eine Internetverbindung haben, um das Notenformular benutzen zu können");
                } else {
                    titleSend.setText("Ihr Konto hat keine Berechtigung für dieses Feature");
                }
            }
        });
        String [] values =
                {"Bitte auswählen*", "Deutsch", "Englisch", "Französisch", "Geschichte & Politik", "Gesellschaft IDAF", "INF-Schulmodule", "Mathematik Grundlagen", "Mathematik Schwerpunkt", "Naturwissenschaften NW I - Physik", "NW II - Chemie", "Sportunterricht", "Sprache & Kommunikation", "Wirtschaft & Recht"};
        Spinner spinner = (Spinner) root.findViewById(R.id.fachSend);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        return root;
    }
}