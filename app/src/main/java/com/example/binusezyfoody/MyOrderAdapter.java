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

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {
    Context ctx;
    ArrayList<Item> order;

    public MyOrderAdapter(Context ctx, ArrayList<Item> order){
        this.ctx = ctx;
        this.order = order;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.ctx).inflate(R.layout.order_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
        Item drink = order.get(position);
        holder.tvName.setText(drink.name);
        holder.tvInfo.setText(drink.quantity + " x Rp " + drink.price);
    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvInfo;
        Button btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvInfo = itemView.findViewById(R.id.tvInfo);
            btnHapus = itemView.findViewById(R.id.btnHapus);

            btnHapus.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            new MainActivity().orders.remove(position);

            Activity activity = (Activity) ctx;
            activity.recreate();
        }

    }
}