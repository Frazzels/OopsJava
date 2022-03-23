package com.example.oops.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class settingsModeModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public settingsModeModel() {
        mText = new MutableLiveData<>();
        mText.setValue("this is settingsMode");
    }

    public LiveData<String> getText() {
        return mText;
    }
}