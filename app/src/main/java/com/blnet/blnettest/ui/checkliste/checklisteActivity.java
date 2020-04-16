package com.blnet.blnettest.ui.checkliste;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;

import com.blnet.blnettest.R;
import com.blnet.blnettest.ui.MainActivity;
import com.blnet.blnettest.ui.register.RegisterActivity;
import com.blnet.blnettest.ui.ui.login.LoginActivity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

        SharedPreferences spCheckliste = getSharedPreferences("save", MODE_PRIVATE);

        chk1.setChecked(spCheckliste.getBoolean("ablagefach", false));
        chk2.setChecked(spCheckliste.getBoolean("paketdienst", false));
        chk3.setChecked(spCheckliste.getBoolean("fenster", false));
        chk4.setChecked(spCheckliste.getBoolean("drucker", false));
        chk5.setChecked(spCheckliste.getBoolean("altpapier", false));
        chk6.setChecked(spCheckliste.getBoolean("kuehl", false));
        chk7.setChecked(spCheckliste.getBoolean("monitor", false));

        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk1.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("ablagefach", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk1.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("ablagefach", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk1.setChecked(false);
                }
            }
        });
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk2.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("paketdienst", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk2.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("paketdienst", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk2.setChecked(false);
                }
            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk3.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("fenster", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk3.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("fenster", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk3.setChecked(false);
                }
            }
        });
        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk4.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("drucker", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk4.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("drucker", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk4.setChecked(false);
                }
            }
        });
        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk5.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("altpapier", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk5.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("altpapier", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk5.setChecked(false);
                }
            }
        });
        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk6.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("kuehl", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk6.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("kuehl", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk6.setChecked(false);
                }
            }
        });
        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk7.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("monitor", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk7.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("monitor", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk7.setChecked(false);
                }
            }
        });
        if (!(spCheckliste.getLong("loeschennach", -1) > System.currentTimeMillis())) {
            SharedPreferences.Editor editor = spCheckliste.edit();
            editor.clear();
            editor.apply();
        }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_login) {
            startActivity(new Intent(checklisteActivity.this, LoginActivity.class));
            return true;
        } else if (id == R.id.action_register) {
            startActivity(new Intent(checklisteActivity.this, RegisterActivity.class));
            return true;
        }
        return false;
    }
    }