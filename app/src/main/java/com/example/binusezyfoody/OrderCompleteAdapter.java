package com.example.binusezyfoody;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderCompleteAdapter extends RecyclerView.Adapter<OrderCompleteAdapter.ViewHolder> {
    Context ctx;
    ArrayList<Item> order;

    public OrderCompleteAdapter(Context ctx, ArrayList<Item> order){
        this.ctx = ctx;
        this.order = order;
    }

    @NonNull
    @Override
    public OrderCompleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.ctx).inflate(R.layout.order_complete_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCompleteAdapter.ViewHolder holder, int position) {
        Item drink = order.get(position);
        holder.tvName.setText(drink.name);
        holder.tvInfo.setText(drink.quantity + " x Rp " + drink.price);
    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvInfo;
        Button btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvInfo = itemView.findViewById(R.id.tvInfo);

        }


    }
}