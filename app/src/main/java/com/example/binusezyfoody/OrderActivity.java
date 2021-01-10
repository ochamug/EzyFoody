package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvPrice;
    EditText txtQuantity;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        txtQuantity = findViewById(R.id.txtQuantity);

        Intent intent = getIntent();
        int orderId = intent.getIntExtra("orderId", 0);
        String orderName = intent.getStringExtra("orderName");
        int orderPrice = intent.getIntExtra("orderPrice", 0);
        item = new MainActivity().stocks.get(orderId-1);

        tvName.setText(orderName);
        tvPrice.setText("Rp " + orderPrice);

    }

    public void placeOrder(View view){
        if(!txtQuantity.getText().toString().equals("")) {

            int quantity = Integer.parseInt(txtQuantity.getText().toString());

            if(item.quantity >= quantity){
                item.quantity = quantity;

                new MainActivity().orders.add(item);

                Intent intent = new Intent(this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }else{
                Toast.makeText(this, item.name + " only have " + item.quantity + " left in their stock", Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Please insert quantity", Toast.LENGTH_SHORT).show();
        }


    }

    public void openMyOrderActivity(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}