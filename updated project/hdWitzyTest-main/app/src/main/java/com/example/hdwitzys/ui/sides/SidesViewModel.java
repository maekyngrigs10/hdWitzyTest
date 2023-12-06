package com.example.hdwitzys.ui.sides;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SidesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SidesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is sides fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}