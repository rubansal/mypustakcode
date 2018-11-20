package com.mypushtak.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mypushtak.app.Adapters.DeliveryAddressAdapter;
import com.mypushtak.app.R;


public class DeliveryAddress extends AppCompatActivity {

    private RecyclerView mRecylerView;
    private RecyclerView.Adapter mAdapter;
    String letterlist[]= {"A","B","C","D","E","F","G","H","I","J","K","L"
            ,"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    int lettersicon[]={R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc
            ,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc
            ,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);
        mRecylerView=findViewById(R.id.address_recyclerview);
        mRecylerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLinearLayout=new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(mLinearLayout);
        Log.d("unique","activity");
        mAdapter=new DeliveryAddressAdapter(this,letterlist);
        mRecylerView.setAdapter(mAdapter);
        Log.d("unique","activity2");
    }
}