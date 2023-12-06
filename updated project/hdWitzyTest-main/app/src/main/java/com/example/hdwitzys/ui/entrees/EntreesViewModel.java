package com.example.hdwitzys.ui.entrees;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EntreesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EntreesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is entrees fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}