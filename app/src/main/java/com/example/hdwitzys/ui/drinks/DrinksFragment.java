package com.example.hdwitzys.ui.drinks;

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

public class DrinksFragment extends Fragment {

    private SharedOrderViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedOrderViewModel.class);

        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        setupItemButton(view, R.id.itemDrinkButton1, 1.00, "Small Drink");
        setupItemButton(view, R.id.itemDrinkButton2, 2.00, "Medium Drink");
        setupItemButton(view, R.id.itemDrinkButton3, 3.00, "Large Drink");

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
