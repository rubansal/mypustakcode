package com.mypushtak.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mypushtak.app.R;

public class ProfileDetailsActivity extends AppCompatActivity {

    Button change_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        change_password=findViewById(R.id.change_password);

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProfileDetailsActivity.this,ChangePassword.class);
                startActivity(i);
            }
        });
    }
}
