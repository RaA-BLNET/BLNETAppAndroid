package com.blnet.blnettest.ui.checkliste;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.lifecycle.Observer;
        import androidx.lifecycle.ViewModelProviders;

        import android.preference.Preference;
        import android.preference.PreferenceManager;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CheckBox;
        import android.widget.TextView;

        import com.blnet.blnettest.R;

        import static android.content.Context.MODE_PRIVATE;


public class checklisteFragment extends Fragment {
    private com.blnet.blnettest.ui.checkliste.checklisteViewModel checklisteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
    //public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //String chk1 = getString(R.id.ablagefach);
        //SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
       // SharedPreferences.Editor edt = pref.edit();
       // edt.putString("ablagefach", chk1);
       // edt.commit();
    //}
}
