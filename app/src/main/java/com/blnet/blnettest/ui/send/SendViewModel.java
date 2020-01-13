package com.blnet.blnettest.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class sendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public sendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Hier kommt das Notenformular");
    }

    public LiveData<String> getText() {
        return mText;
    }
}