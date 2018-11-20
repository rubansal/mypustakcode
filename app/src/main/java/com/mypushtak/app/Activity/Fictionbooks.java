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

public class Fictionbooks extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView home_icon;
    ImageView school_image;
    ImageView university_image;
    ImageView competitive_image;

    ImageView fiction1_image;
    ImageView nonfiction_image;
    ImageView religion_image;

    LinearLayout fiction_layout;
    LinearLayout nonfiction_layout;
    LinearLayout religion_layout;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fictionbooks);

        home_icon=findViewById(R.id.home_icon);

        school_image=findViewById(R.id.school_image);
        university_image=findViewById(R.id.university_image);
        competitive_image=findViewById(R.id.competitive_image);

        fiction1_image=findViewById(R.id.fiction1_image);
        nonfiction_image=findViewById(R.id.nonfiction_image);
        religion_image=findViewById(R.id.religion_image);

        fiction_layout=findViewById(R.id.fiction_layout);
        nonfiction_layout=findViewById(R.id.nonfiction_layout);
        religion_layout=findViewById(R.id.religion_layout);

        fiction1_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                religion_layout.setVisibility(View.GONE);
                nonfiction_layout.setVisibility(View.GONE);
                fiction_layout.setVisibility(View.VISIBLE);
            }
        });

        nonfiction_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                religion_layout.setVisibility(View.GONE);
                fiction_layout.setVisibility(View.GONE);
                nonfiction_layout.setVisibility(View.VISIBLE);
            }
        });

        religion_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nonfiction_layout.setVisibility(View.GONE);
                fiction_layout.setVisibility(View.GONE);
                religion_layout.setVisibility(View.VISIBLE);
            }
        });

        school_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fictionbooks.this,Schoolbooks.class);
                startActivity(i);
                finish();
            }
        });

        university_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fictionbooks.this,Universitybooks.class);
                startActivity(i);
                finish();
            }
        });


        competitive_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fictionbooks.this,Competitivebooks.class);
                startActivity(i);
                finish();
            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(Fictionbooks.this,DividerItemDecoration.VERTICAL));

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
