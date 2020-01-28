package com.blnet.blnettest.ui.infos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.blnet.blnettest.R;

public class infosFragment extends Fragment {

    private infosViewModel infosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infosViewModel =
                ViewModelProviders.of(this).get(infosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_infos, container, false);
        final TextView textView = root.findViewById(R.id.text_infos);
        infosViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}