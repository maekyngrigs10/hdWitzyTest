package com.example.hdwitzys.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.hdwitzys.R;
import com.example.hdwitzys.ui.SharedOrderViewModel.OrderItem;
import java.util.List;

public class OrderItemAdapter extends ArrayAdapter<OrderItem> {

    private List<OrderItem> orderItems;
    private SharedOrderViewModel viewModel;

    public OrderItemAdapter(Context context, List<OrderItem> orderItems, SharedOrderViewModel viewModel) {
        super(context, R.layout.list_item_order, orderItems);
        this.orderItems = orderItems;
        this.viewModel = viewModel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_order, parent, false);
        }

        OrderItem item = getItem(position);

        TextView tvName = convertView.findViewById(R.id.itemNameTextView);
        tvName.setText(item.getItemName());

        TextView tvPrice = convertView.findViewById(R.id.itemPriceTextView);
        tvPrice.setText("$" + String.format("%.2f", item.getPrice())); // Display the item's price

        Button deleteButton = convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(v -> {
            viewModel.subtractFromTotal(item.getPrice());
            orderItems.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        notifyDataSetChanged();
    }
}
