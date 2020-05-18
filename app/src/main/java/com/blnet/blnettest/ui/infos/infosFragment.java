package com.blnet.blnettest.ui.infos;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.blnet.blnettest.R;

public class infosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_infos, container, false);
        TextView text = (TextView) v.findViewById(R.id.datei);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text1 = (TextView) v.findViewById(R.id.leiitfaden);
        text1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text3 = (TextView) v.findViewById(R.id.dateibspw);
        text3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text4 = (TextView) v.findViewById(R.id.dateibsps);
        text4.setMovementMethod(LinkMovementMethod.getInstance());
        return v;

    }
}