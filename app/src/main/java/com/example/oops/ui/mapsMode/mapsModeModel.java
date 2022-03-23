package com.example.oops.ui.mapsMode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mapsModeModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public mapsModeModel() {
        mText = new MutableLiveData<>();
        mText.setValue("this is mapsMode");
    }

    public LiveData<String> getText() {
        return mText;
    }
}