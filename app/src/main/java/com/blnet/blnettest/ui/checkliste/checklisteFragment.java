package com.blnet.blnettest.ui.checkliste;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blnet.blnettest.R;


public class checklisteFragment extends Fragment {

    private com.blnet.blnettest.ui.checkliste.checklisteViewModel checklisteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checklisteViewModel =
                ViewModelProviders.of(this).get(com.blnet.blnettest.ui.checkliste.checklisteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_checkliste, container, false);
        final TextView textView = root.findViewById(R.id.text_checkliste);
        checklisteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
