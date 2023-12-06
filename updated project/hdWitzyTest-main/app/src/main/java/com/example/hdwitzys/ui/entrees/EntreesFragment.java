package com.example.hdwitzys.ui.entrees;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.hdwitzys.R;
import com.example.hdwitzys.ui.SharedOrderViewModel;

public class EntreesFragment extends Fragment {

    private SharedOrderViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedOrderViewModel.class);

        View view = inflater.inflate(R.layout.fragment_entrees, container, false);

        setupItemButton(view, R.id.itemEntreeButton1, 3.00, "Hamburger/Cheeseburger");
        setupItemButton(view, R.id.itemEntreeButton2, 4.00, "Double Ritz");
        setupItemButton(view, R.id.itemEntreeButton3, 3.00, "Fish Sandwich");
        setupItemButton(view, R.id.itemEntreeButton4, 5.00, "Chicken Grill");
        setupItemButton(view, R.id.itemEntreeButton5, 4.50, "World's Best PB&J");
        setupItemButton(view, R.id.itemEntreeButton6, 3.50, "All-American Hot Dog");
        setupItemButton(view, R.id.itemEntreeButton7, 3.50, "Coney Dog");
        setupItemButton(view, R.id.itemEntreeButton8, 4.00, "Coney Dog w/ Cheese");

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
