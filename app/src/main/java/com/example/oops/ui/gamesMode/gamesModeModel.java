package com.example.oops.ui.gamesMode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class gamesModeModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public gamesModeModel() {
        mText = new MutableLiveData<>();
        mText.setValue("this is gamesMode");
    }

    public LiveData<String> getText() {
        return mText;
    }
}