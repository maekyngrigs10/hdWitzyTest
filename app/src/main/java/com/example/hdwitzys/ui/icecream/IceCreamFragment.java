package com.example.hdwitzys.ui.icecream;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hdwitzys.databinding.FragmentEntreesBinding;

public class IceCreamFragment extends Fragment {

    private FragmentEntreesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IceCreamViewModel entreesViewModel =
                new ViewModelProvider(this).get(IceCreamViewModel.class);

        binding = FragmentEntreesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textIceCream;
//        IceCreamViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}