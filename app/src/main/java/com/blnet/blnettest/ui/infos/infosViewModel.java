package com.blnet.blnettest.ui.infos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class infosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public infosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Hier kommen wichtige Informationen");
    }

    public LiveData<String> getText() {
        return mText;
    }
}