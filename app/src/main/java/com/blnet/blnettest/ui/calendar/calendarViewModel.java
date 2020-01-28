package com.blnet.blnettest.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class calendarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public calendarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Hier kommt der Kalender");
    }

    public LiveData<String> getText() {
        return mText;
    }
}