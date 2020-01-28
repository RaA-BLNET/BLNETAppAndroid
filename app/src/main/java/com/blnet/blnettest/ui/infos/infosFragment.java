package com.blnet.blnettest.ui.infos;

import android.os.Bundle;
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
            WebView webView = (WebView) v.findViewById(R.id.infos_html);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementById('masthead').style.display='none';})()");
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementById('colophon').style.display='none';})()");
                }
            });
            webView.loadUrl("https://www.blnet.ch/infos/");
            return v;
        }
    }