package com.blnet.blnettest.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.blnet.blnettest.R;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.navigation.ui.NavigationUI;

import com.blnet.blnettest.ui.checkliste.checklisteFragment;
import com.blnet.blnettest.ui.pwreset.pwresetActivity;
import com.blnet.blnettest.ui.register.RegisterActivity;
import com.blnet.blnettest.ui.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;


public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseAnalytics firebaseUserPush;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseUserPush = FirebaseAnalytics.getInstance(this);
        SharedPreferences spLogin = getSharedPreferences("loggedinuser", MODE_PRIVATE);
        String emailiden = spLogin.getString("email", "");
        firebaseUserPush.setUserProperty("email", emailiden);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_send, R.id.nav_infos, R.id.nav_calendar, R.id.nav_checkliste)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_login) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            return true;
        } else if (id == R.id.action_register) {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            return true;
        } else if (id == R.id.action_pwreset) {
            startActivity(new Intent(MainActivity.this, pwresetActivity.class));
        }
        return false;
    }

}