package com.example.hdwitzys.ui.icecream;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hdwitzys.R;
import com.example.hdwitzys.ui.SharedOrderViewModel;

public class IceCreamFragment extends Fragment {

    private SharedOrderViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedOrderViewModel.class);

        View view = inflater.inflate(R.layout.fragment_icecream, container, false);

        setupItemButton(view, R.id.singleScoopButton, 1.00, "Single Scoop");
        setupItemButton(view, R.id.doubleScoopButton, 2.00, "Double Scoop");
        setupItemButton(view, R.id.tripleScoopButton, 3.00, "Triple Scoop");
        setupItemButton(view, R.id.milkshakeButton, 3.50, "Milkshake");
        setupItemButton(view, R.id.rootBeerFloatButton, 3.00, "Root Beer Float");
        setupItemButton(view, R.id.maltButton, 3.50, "Malt");
        setupItemButton(view, R.id.bananaSplitButton, 4.00, "Banana Split");
        setupItemButton(view, R.id.pintButton, 5.00, "Pint");
        setupItemButton(view, R.id.quartButton, 6.00, "Quart");

        return view;
    }

    private void setupItemButton(View view, int buttonId, double price, String itemName) {
        Button button = view.findViewById(buttonId);
        button.setOnClickListener(v -> {
            viewModel.addOrderItem(itemName, price);
            Toast.makeText(requireContext(), "Added to order: " + itemName + " $" + price, Toast.LENGTH_SHORT).show();
        });
    }
}
