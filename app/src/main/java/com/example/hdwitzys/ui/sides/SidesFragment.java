package com.example.hdwitzys.ui.sides;

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

public class SidesFragment extends Fragment {

    private SharedOrderViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedOrderViewModel.class);

        View view = inflater.inflate(R.layout.fragment_sides, container, false);

        setupItemButton(view, R.id.itemSideButton1, 4.00, "5-way Chili");
        setupItemButton(view, R.id.itemSideButton2, 3.00, "Shoestring Fries");
        setupItemButton(view, R.id.itemSideButton3, 4.00, "Steamed Vegetables");
        setupItemButton(view, R.id.itemSideButton4, 3.00, "Side Salad");
        setupItemButton(view, R.id.itemSideButton5, 5.00, "Choice Garden Salad");
        setupItemButton(view, R.id.itemSideButton6, 5.50, "Deluxe Garden Salad");
        setupItemButton(view, R.id.tacoSaladButton, 6.00, "Taco Salad");
        setupItemButton(view, R.id.chickenSaladButton, 6.50, "Chicken Salad");

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
