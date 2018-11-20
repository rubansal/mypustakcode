package com.mypushtak.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mypushtak.app.R;

public class AdditionalDeliveryAddress extends AppCompatActivity {

    Button add_another_address;
    Button add_delivery_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_delivery_address);

        add_another_address=findViewById(R.id.add_another_address);
        add_delivery_edit=findViewById(R.id.additional_delivery_edit);

        add_another_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdditionalDeliveryAddress.this,AddAddress.class);
                startActivity(i);
            }
        });

        add_delivery_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdditionalDeliveryAddress.this, EditAddress.class);
                startActivity(i);
            }
        });
    }
}
