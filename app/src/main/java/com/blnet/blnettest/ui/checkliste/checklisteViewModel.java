package com.blnet.blnettest.ui.checkliste;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class checklisteViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public checklisteViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
