package com.blnet.blnettest.ui.calendar;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.blnet.blnettest.R;
import com.blnet.blnettest.ui.login.LoginActivity;

public class calendarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_calendar, container, false);

        WebView webView = (WebView) v.findViewById(R.id.calendar_html);
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
        webView.loadUrl("https://www.blnet.ch/kalender/");
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            webView.setVisibility(View.GONE);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(getString(R.string.titlecal))
                    .setMessage(getString(R.string.infocal))
                    .create()
                    .show();
        } else {
            webView.setVisibility(View.VISIBLE);
        }
        return v;
    }}




