package com.example.hdwitzys.ui.checkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation; // Import the Navigation class
import com.example.hdwitzys.R;
import com.example.hdwitzys.ui.OrderItemAdapter;
import com.example.hdwitzys.ui.SharedOrderViewModel;

public class PaymentFragment extends Fragment {

    private SharedOrderViewModel viewModel;
    private TextView totalCostTextView;
    private ListView checkoutListView;
    private OrderItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedOrderViewModel.class);

        totalCostTextView = view.findViewById(R.id.totalCostTextView);
        checkoutListView = view.findViewById(R.id.checkoutListView);

        adapter = new OrderItemAdapter(getContext(), viewModel.getOrderItems().getValue(), viewModel);
        checkoutListView.setAdapter(adapter);

        viewModel.getTotalCost().observe(getViewLifecycleOwner(), totalCost ->
                totalCostTextView.setText("Total: $" + String.format("%.2f", totalCost)));

        viewModel.getOrderItems().observe(getViewLifecycleOwner(), orderItems -> {
            adapter.setOrderItems(orderItems);
            adapter.notifyDataSetChanged();
        });

        // Set up a click listener for the "Continue To Payment" button
        Button continueToPaymentButton = view.findViewById(R.id.paymentButton);
        continueToPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the PaymentFragment when the button is clicked
                Navigation.findNavController(v).navigate(R.id.action_checkoutFragment_to_paymentFragment);
            }
        });

        return view;
    }
}
