package com.mypushtak.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mypushtak.app.R;

public class productfullview extends AppCompatActivity {

    ImageView cart_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productfullview);

        cart_image=findViewById(R.id.cart_image);
        cart_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(productfullview.this,CartItemsActivity.class);
                startActivity(i);
            }
        });
    }
}
