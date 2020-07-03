package com.blnet.blnettest.ui.infos;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TableLayout;
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
        TextView text1 = (TextView) v.findViewById(R.id.leiitfaden);
        TextView text3 = (TextView) v.findViewById(R.id.dateibspw);
        TextView text4 = (TextView) v.findViewById(R.id.dateibsps);
        TextView aemtliplantitel = (TextView) v.findViewById(R.id.aemtlipla);
        TableLayout aemtlitable = (TableLayout) v.findViewById(R.id.tableLayout);
        TextView itrichtlinientitel = (TextView) v.findViewById(R.id.aemtliplan28);
        TextView leitfadentitel = (TextView) v.findViewById(R.id.aemtliplan29);
        TextView zeitausweistitel = (TextView) v.findViewById(R.id.aemtliplan30);
        TextView zeitausweisbeschr = (TextView) v.findViewById(R.id.aemtliplan31);

        text.setMovementMethod(LinkMovementMethod.getInstance());
        text1.setMovementMethod(LinkMovementMethod.getInstance());
        text3.setMovementMethod(LinkMovementMethod.getInstance());
        text4.setMovementMethod(LinkMovementMethod.getInstance());
        return v;

    }
}