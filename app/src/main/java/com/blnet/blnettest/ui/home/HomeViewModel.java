package com.blnet.blnettest.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Herzlich willkommen in der BLNET-App. Hier können sie ihre Schulnoten eintragen, schauen ob man Ämtli/Paketdienst hat und den BL-Kalender überprüfen.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}