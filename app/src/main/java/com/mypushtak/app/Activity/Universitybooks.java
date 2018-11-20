package com.mypushtak.app.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mypushtak.app.R;

public class Universitybooks extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView home_icon;
    ImageView school_image;
    ImageView competitive_image;
    ImageView fiction_image;

    ImageView engineering_image;
    ImageView medical_image;
    ImageView scienceandarts_image;
    ImageView otheruniversity_image;

    LinearLayout engineering_layout;
    LinearLayout medical_layout;
    LinearLayout scienceandarts_layout;
    LinearLayout otheruniversity_layout;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universitybooks);

        home_icon=findViewById(R.id.home_icon);
        school_image=findViewById(R.id.school_image);
        competitive_image=findViewById(R.id.competitive_image);
        fiction_image=findViewById(R.id.fiction_image);

        engineering_image=findViewById(R.id.engineering_image);
        medical_image=findViewById(R.id.medical_image);
        scienceandarts_image=findViewById(R.id.scienceandarts_image);
        otheruniversity_image=findViewById(R.id.otheruniversity_image);

        engineering_layout=findViewById(R.id.engineering_layout);
        medical_layout=findViewById(R.id.medical_layout);
        scienceandarts_layout=findViewById(R.id.scienceandarts_layout);
        otheruniversity_layout=findViewById(R.id.otheruniversity_layout);

        engineering_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otheruniversity_layout.setVisibility(View.GONE);
                scienceandarts_layout.setVisibility(View.GONE);
                medical_layout.setVisibility(View.GONE);
                engineering_layout.setVisibility(View.VISIBLE);
            }
        });

        medical_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otheruniversity_layout.setVisibility(View.GONE);
                scienceandarts_layout.setVisibility(View.GONE);
                engineering_layout.setVisibility(View.GONE);
                medical_layout.setVisibility(View.VISIBLE);
            }
        });

        scienceandarts_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otheruniversity_layout.setVisibility(View.GONE);
                medical_layout.setVisibility(View.GONE);
                engineering_layout.setVisibility(View.GONE);
                scienceandarts_layout.setVisibility(View.VISIBLE);
            }
        });

        otheruniversity_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scienceandarts_layout.setVisibility(View.GONE);
                medical_layout.setVisibility(View.GONE);
                engineering_layout.setVisibility(View.GONE);
                otheruniversity_layout.setVisibility(View.VISIBLE);
            }
        });

        school_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Universitybooks.this,Schoolbooks.class);
                startActivity(i);
                finish();
            }
        });

        competitive_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Universitybooks.this,Competitivebooks.class);
                startActivity(i);
                finish();
            }
        });


        fiction_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Universitybooks.this,Fictionbooks.class);
                startActivity(i);
                finish();
            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(Universitybooks.this,DividerItemDecoration.VERTICAL));

        navigationView.getMenu().getItem(1).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(2).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);

        navigationView.setNavigationItemSelectedListener(this);

        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(Gravity.START);
                else
                    drawerLayout.closeDrawer(Gravity.END);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            Intent i1=new Intent(this,ProfileActivity.class);
            startActivity(i1);
            return true;
        }else if(id == R.id.nav_school_bus){
            Intent i1=new Intent(this,ProductView.class);
            startActivity(i1);
//            Intent cartIntent = new Intent(Home.this, Cart.class);
//            startActivity(cartIntent);

        }else if(id == R.id.nav_univ_books){
            Intent i1=new Intent(this,ProfileDetailsActivity.class);
            startActivity(i1);
//            Intent orderIntent = new Intent(Home.this, OrderStatus.class);
//            startActivity(orderIntent);

        }else if(id == R.id.nav_compet_exams){
            Intent i1=new Intent(this,productfullview.class);
            startActivity(i1);
//            AccountKit.logOut();
//            Intent signIn = new Intent(Home.this, ScreenOneActivity.class);
//            signIn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(signIn);
        }
        else if(id == R.id.nav_fiction_books){
//            showChangePasswordDialog();

        }
        else if(id == R.id.nav_faqs){
//            startActivity(new Intent(Home.this,NearbyStore.class));
        }
        else if(id == R.id.nav_con_us){
//            showHomeAddressDialog();

        }
        else if(id == R.id.nav_rate_us){
//            showHomeSettingDialog();
        }
        else if(id == R.id.nav_abt_us){
//            startActivity(new Intent(Home.this,FavoritesActivity.class));
        }
        else if(id == R.id.nav_term_of_use){
//            startActivity(new Intent(Home.this,FavoritesActivity.class));
        }
        else if(id == R.id.nav_prd_donors){
//            startActivity(new Intent(Home.this,FavoritesActivity.class));
        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
