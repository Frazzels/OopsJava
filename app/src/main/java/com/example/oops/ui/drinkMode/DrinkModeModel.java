package com.example.oops.ui.drinkMode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DrinkModeModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DrinkModeModel() {
        mText = new MutableLiveData<>();
        mText.setValue("this is drinkMode");
    }

    public LiveData<String> getText() {
        return mText;
    }
}