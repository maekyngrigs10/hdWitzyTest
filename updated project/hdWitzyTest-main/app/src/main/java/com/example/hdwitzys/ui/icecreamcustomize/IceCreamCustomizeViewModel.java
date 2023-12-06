package com.example.hdwitzys.ui.icecreamcustomize;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IceCreamCustomizeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public IceCreamCustomizeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ice cream customize fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}