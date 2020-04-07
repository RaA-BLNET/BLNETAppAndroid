package com.blnet.blnettest.ui.checkliste;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;

import com.blnet.blnettest.R;

import static android.content.Context.MODE_PRIVATE;
public class checklisteActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_checkliste);
        final CheckBox chk1;
        final CheckBox chk2;
        final CheckBox chk3;
        final CheckBox chk4;
        final CheckBox chk5;
        final CheckBox chk6;
        final CheckBox chk7;
        super.onCreate(savedInstanceState);
        // checkliste code test
        chk1 = findViewById(R.id.ablagefach);
        chk2 = findViewById(R.id.paketdienst);
        chk3 = findViewById(R.id.fenster);
        chk4 = findViewById(R.id.drucker);
        chk5 = findViewById(R.id.altpapier);
        chk6 = findViewById(R.id.kuehl);
        chk7 = findViewById(R.id.monitor);
        SharedPreferences sharedPreferences1 = getSharedPreferences("save1", MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getSharedPreferences("save2", MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getSharedPreferences("save3", MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getSharedPreferences("save4", MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getSharedPreferences("save5", MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getSharedPreferences("save6", MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getSharedPreferences("save7", MODE_PRIVATE);


        chk1.setChecked(sharedPreferences1.getBoolean("value1", false));
        chk2.setChecked(sharedPreferences2.getBoolean("value2", false));
        chk3.setChecked(sharedPreferences3.getBoolean("value3", false));
        chk4.setChecked(sharedPreferences4.getBoolean("value4", false));
        chk5.setChecked(sharedPreferences5.getBoolean("value5", false));
        chk6.setChecked(sharedPreferences6.getBoolean("value6", false));
        chk7.setChecked(sharedPreferences7.getBoolean("value7", false));

        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk1.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save1", MODE_PRIVATE).edit();
                    editor.putBoolean("value1", true);
                    editor.apply();
                    chk1.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save1", MODE_PRIVATE).edit();
                    editor.putBoolean("value1", false);
                    editor.apply();
                    chk1.setChecked(false);
                }
            }
        });
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk2.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor.putBoolean("value2", true);
                    editor.apply();
                    chk2.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor.putBoolean("value2", false);
                    editor.apply();
                    chk2.setChecked(false);
                }
            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk3.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor.putBoolean("value3", true);
                    editor.apply();
                    chk3.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor.putBoolean("value3", false);
                    editor.apply();
                    chk3.setChecked(false);
                }
            }
        });
        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk4.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor.putBoolean("value4", true);
                    editor.apply();
                    chk4.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor.putBoolean("value4", false);
                    editor.apply();
                    chk4.setChecked(false);
                }
            }
        });
        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk5.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor.putBoolean("value5", true);
                    editor.apply();
                    chk5.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor.putBoolean("value5", false);
                    editor.apply();
                    chk5.setChecked(false);
                }
            }
        });
        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk6.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor.putBoolean("value6", true);
                    editor.apply();
                    chk6.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor.putBoolean("value6", false);
                    editor.apply();
                    chk6.setChecked(false);
                }
            }
        });
        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk7.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor.putBoolean("value7", true);
                    editor.apply();
                    chk7.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor.putBoolean("value7", false);
                    editor.apply();
                    chk7.setChecked(false);
                }
            }
        });

    }
}