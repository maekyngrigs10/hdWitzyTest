package com.example.hdwitzys.ui;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.hdwitzys.R;
import com.example.hdwitzys.ui.SharedOrderViewModel.OrderItem;
import java.util.List;

public class OrderItemAdapter extends ArrayAdapter<OrderItem> {

    private List<OrderItem> orderItems;

    public OrderItemAdapter(Context context, List<OrderItem> orderItems) {
        super(context, android.R.layout.simple_list_item_2, orderItems);
        this.orderItems = orderItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderItem orderItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        TextView text1 = (TextView) convertView.findViewById(android.R.id.text1);
        TextView text2 = (TextView) convertView.findViewById(android.R.id.text2);

        text1.setText(orderItem.getItemName());
        text2.setText("$" + String.format("%.2f", orderItem.getPrice()));

        return convertView;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        notifyDataSetChanged();
    }
}
