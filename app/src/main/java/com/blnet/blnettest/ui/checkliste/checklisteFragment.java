package com.blnet.blnettest.ui.checkliste;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blnet.blnettest.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.TimeUnit;

import static android.content.Context.MODE_PRIVATE;

public class checklisteFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2,tab3;
    public PagerAdapter pagerAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assert getFragmentManager() != null;
        final View view = inflater.inflate(R.layout.fragment_checkliste, container, false);
        final TextView titelchk;
        final CheckBox chk1;
        final CheckBox chk2;
        final CheckBox chk3;
        final CheckBox chk4;
        final CheckBox chk5;
        final CheckBox chk6;
        final CheckBox chk7;
        final CheckBox chk8;
        final CheckBox chk9;
        final CheckBox chk10;
        final CheckBox chk11;
        final CheckBox chk12;
        final CheckBox chk13;
        final CheckBox chk14;
        final CheckBox chk15;
        super.onCreate(savedInstanceState);
        // checkliste code
        titelchk = view.findViewById(R.id.text_checkliste);
        chk1 = view.findViewById(R.id.ablagefach);
        chk2 = view.findViewById(R.id.paketdienst);
        chk3 = view.findViewById(R.id.fenster);
        chk4 = view.findViewById(R.id.drucker);
        chk5 = view.findViewById(R.id.altpapier);
        chk6 = view.findViewById(R.id.kuehl);
        chk7 = view.findViewById(R.id.monitor);
        chk8 = view.findViewById(R.id.aeschen);
        chk9 = view.findViewById(R.id.abfall);
        chk10 = view.findViewById(R.id.tische);
        chk11 = view.findViewById(R.id.baenke);
        chk12 = view.findViewById(R.id.boden);
        chk13 = view.findViewById(R.id.vollabfall);
        chk14 = view.findViewById(R.id.mikro);
        final Button button3 = (Button) view.findViewById(R.id.button3);
        final Button button2 = (Button) view.findViewById(R.id.button2);
        // standardmässige einstellung (wenn tab geöffnet wird)
        button3.setEnabled(true);
        button2.setEnabled(false);
        titelchk.setText(R.string.checkliste_text);
        chk8.setVisibility(View.GONE);
        chk9.setVisibility(View.GONE);
        chk10.setVisibility(View.GONE);
        chk11.setVisibility(View.GONE);
        chk12.setVisibility(View.GONE);
        chk13.setVisibility(View.GONE);
        chk14.setVisibility(View.GONE);




        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titelchk.setText(R.string.checkliste_text_putz);
                button3.setEnabled(false);
                button2.setEnabled(true);
                chk1.setVisibility(View.GONE);
                chk2.setVisibility(View.GONE);
                chk3.setVisibility(View.GONE);
                chk4.setVisibility(View.GONE);
                chk5.setVisibility(View.GONE);
                chk6.setVisibility(View.GONE);
                chk7.setVisibility(View.GONE);
                chk8.setVisibility(View.VISIBLE);
                chk9.setVisibility(View.VISIBLE);
                chk10.setVisibility(View.VISIBLE);
                chk11.setVisibility(View.VISIBLE);
                chk12.setVisibility(View.VISIBLE);
                chk13.setVisibility(View.VISIBLE);
                chk14.setVisibility(View.VISIBLE);

            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titelchk.setText(R.string.checkliste_text);
                button3.setEnabled(true);
                button2.setEnabled(false);
                chk1.setVisibility(View.VISIBLE);
                chk2.setVisibility(View.VISIBLE);
                chk3.setVisibility(View.VISIBLE);
                chk4.setVisibility(View.VISIBLE);
                chk5.setVisibility(View.VISIBLE);
                chk6.setVisibility(View.VISIBLE);
                chk7.setVisibility(View.VISIBLE);
                chk8.setVisibility(View.GONE);
                chk9.setVisibility(View.GONE);
                chk10.setVisibility(View.GONE);
                chk11.setVisibility(View.GONE);
                chk12.setVisibility(View.GONE);
                chk13.setVisibility(View.GONE);
                chk14.setVisibility(View.GONE);

            }
        });

                SharedPreferences spCheckliste = getActivity().getSharedPreferences("save", MODE_PRIVATE);

        chk1.setChecked(spCheckliste.getBoolean("ablagefach", false));
        chk2.setChecked(spCheckliste.getBoolean("paketdienst", false));
        chk3.setChecked(spCheckliste.getBoolean("fenster", false));
        chk4.setChecked(spCheckliste.getBoolean("drucker", false));
        chk5.setChecked(spCheckliste.getBoolean("altpapier", false));
        chk6.setChecked(spCheckliste.getBoolean("kuehl", false));
        chk7.setChecked(spCheckliste.getBoolean("monitor", false));
        chk8.setChecked(spCheckliste.getBoolean("aeschen", false));
        chk9.setChecked(spCheckliste.getBoolean("abfall", false));
        chk10.setChecked(spCheckliste.getBoolean("tische", false));
        chk11.setChecked(spCheckliste.getBoolean("baenke", false));
        chk12.setChecked(spCheckliste.getBoolean("boden", false));
        chk13.setChecked(spCheckliste.getBoolean("vollabfall", false));
        chk14.setChecked(spCheckliste.getBoolean("mikro", false));


        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk1.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("ablagefach", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk1.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
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
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("paketdienst", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk2.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
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
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("fenster", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk3.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
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
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("drucker", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk4.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
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
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("altpapier", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk5.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
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
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("kuehl", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk6.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
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
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("monitor", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk7.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("monitor", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk7.setChecked(false);
                }
            }
        });
        chk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk8.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("aeschen", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk8.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("aeschen", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk8.setChecked(false);
                }
            }
        });
        chk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk9.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("abfall", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk9.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("abfall", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk9.setChecked(false);
                }
            }
        });
        chk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk10.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("tische", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk10.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("tische", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk10.setChecked(false);
                }
            }
        });
        chk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk11.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("baenke", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk11.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("baenke", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk11.setChecked(false);
                }
            }
        });
        chk12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk12.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("boden", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk12.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("boden", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk12.setChecked(false);
                }
            }
        });
        chk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk13.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("vollabfall", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk13.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("vollabfall", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk13.setChecked(false);
                }
            }
        });
        chk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk14.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("mikro", true);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk14.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("mikro", false);
                    editor.putLong("loeschennach", System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(720));
                    editor.apply();
                    chk14.setChecked(false);
                }
            }
        });
        if (!(spCheckliste.getLong("loeschennach", -1) > System.currentTimeMillis())) {
            SharedPreferences.Editor editor = spCheckliste.edit();
            editor.clear();
            editor.apply();
        }
        return view;
        }
    }