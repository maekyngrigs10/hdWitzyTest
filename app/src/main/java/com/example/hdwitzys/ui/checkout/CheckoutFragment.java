package com.example.hdwitzys.ui.checkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hdwitzys.R;
import com.example.hdwitzys.databinding.FragmentCheckoutBinding;

import java.util.ArrayList;

public class CheckoutFragment extends Fragment {

    private FragmentCheckoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCheckoutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Assuming you have a list of items in the order, customize based on your data structure
        ArrayList<String> orderItemList = getOrderItemList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, orderItemList);

        ListView listView = binding.checkoutListView;
        listView.setAdapter(adapter);

        // Handle delete button click
        Button deleteButton = binding.deleteButton;
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to delete the selected item from the order
                // Update the adapter and refresh the ListView
                // You might want to implement a method like deleteItem(int position)
            }
        });

        // Add any additional logic or UI customization specific to the CheckoutFragment

        return view;
    }

    // Replace this with your actual method to get order items data
    private ArrayList<String> getOrderItemList() {
        ArrayList<String> orderItemList = new ArrayList<>();
        // Populate the list with items in the order
        orderItemList.add("Cheeseburger");
        // Add more items as needed
        return orderItemList;
    }
}
