package com.example.hdwitzys.ui.entreecustomize;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EntreeCustomizeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EntreeCustomizeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is entree  customize fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}