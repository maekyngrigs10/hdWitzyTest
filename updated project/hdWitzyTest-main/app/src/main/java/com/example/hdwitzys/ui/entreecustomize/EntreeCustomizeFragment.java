package com.example.hdwitzys.ui.entreecustomize;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hdwitzys.databinding.FragmentEntreecustomizeBinding;

public class EntreeCustomizeFragment extends Fragment {

    private FragmentEntreecustomizeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EntreeCustomizeViewModel newViewModel2 =
                new ViewModelProvider(this).get(EntreeCustomizeViewModel.class);

        binding = FragmentEntreecustomizeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textEntreeCustomize;
//        newViewModel2.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}