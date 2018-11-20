package com.mypushtak.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mypushtak.app.R;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout profiledetails_layout;
    LinearLayout address_layout;
    LinearLayout offer_layout;
    LinearLayout wallet_layout;
    LinearLayout donationstatus_layout;
    LinearLayout order_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profiledetails_layout=findViewById(R.id.profiledetails_layout);
        address_layout=findViewById(R.id.address_layout);
        offer_layout=findViewById(R.id.offer_layout);
        wallet_layout=findViewById(R.id.wallet_layout);
        donationstatus_layout=findViewById(R.id.donationstatus_layout);
        order_layout=findViewById(R.id.orders_layout);

        profiledetails_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivity.this, ProfileDetailsActivity.class);
                startActivity(i);
            }
        });

        address_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivity.this,AdditionalDeliveryAddress.class);
                startActivity(i);
            }
        });

        offer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivity.this,OfferZone.class);
                startActivity(i);
            }
        });

        wallet_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivity.this,wallet.class);
                startActivity(i);
            }
        });

        donationstatus_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivity.this,DonationStatus.class);
                startActivity(i);
            }
        });

        order_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileActivity.this,MyOrders.class);
                startActivity(i);
            }
        });
    }
}
