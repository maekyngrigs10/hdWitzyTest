package com.example.hdwitzys.ui.sides;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hdwitzys.databinding.FragmentEntreesBinding;

public class SidesFragment extends Fragment {

    private FragmentEntreesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SidesViewModel entreesViewModel =
                new ViewModelProvider(this).get(SidesViewModel.class);

        binding = FragmentEntreesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSides;
        SidesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}