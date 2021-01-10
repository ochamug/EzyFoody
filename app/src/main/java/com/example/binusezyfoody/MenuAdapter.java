package com.example.binusezyfoody;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>{
    Context ctx;
    ArrayList<Item> menu;

    public MenuAdapter(Context ctx, ArrayList<Item> menu){
        this.ctx = ctx;
        this.menu = menu;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.ctx).inflate(R.layout.menu_row, parent, false);
        return new MenuAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Item drink = menu.get(position);
        holder.ivThumbnail.setImageResource(drink.thumbnail);
        holder.tvName.setText(drink.name);
        holder.tvPrice.setText("Rp " + drink.price);
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivThumbnail;
        TextView tvName;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Item item = menu.get(position);
            Intent intent = new Intent(ctx, OrderActivity.class);
            intent.putExtra("orderId", item.id);
            intent.putExtra("orderName", item.name);
            intent.putExtra("orderPrice", item.price);
            ctx.startActivity(intent);
        }
    }
}

