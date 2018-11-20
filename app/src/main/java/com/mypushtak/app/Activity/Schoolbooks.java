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

public class Schoolbooks extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView home_icon;
    ImageView university_image;
    ImageView competitive_image;
    ImageView fiction_image;

    ImageView children_image;
    ImageView class_image;
    ImageView dic_image;
    ImageView ncert_image;

    LinearLayout childrenbooks_layout;
    LinearLayout classes_layout;
    LinearLayout dictionary_layout;
    LinearLayout ncert_layout;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolbooks);

        home_icon=findViewById(R.id.home_icon);
        university_image=findViewById(R.id.university_image);
        competitive_image=findViewById(R.id.competitive_image);
        fiction_image=findViewById(R.id.fiction_image);

        children_image=findViewById(R.id.children_image);
        class_image=findViewById(R.id.class_image);
        dic_image=findViewById(R.id.dic_image);
        ncert_image=findViewById(R.id.ncert_image);

        childrenbooks_layout=findViewById(R.id.childrenbooks_layout);
        classes_layout=findViewById(R.id.classes_layout);
        dictionary_layout=findViewById(R.id.dictionary_layout);
        ncert_layout=findViewById(R.id.ncert_layout);

        children_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ncert_layout.setVisibility(View.GONE);
                classes_layout.setVisibility(View.GONE);
                dictionary_layout.setVisibility(View.GONE);
                childrenbooks_layout.setVisibility(View.VISIBLE);
            }
        });

        class_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ncert_layout.setVisibility(View.GONE);
                childrenbooks_layout.setVisibility(View.GONE);
                dictionary_layout.setVisibility(View.GONE);
                classes_layout.setVisibility(View.VISIBLE);
            }
        });

        dic_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ncert_layout.setVisibility(View.GONE);
                classes_layout.setVisibility(View.GONE);
                childrenbooks_layout.setVisibility(View.GONE);
                dictionary_layout.setVisibility(View.VISIBLE);
            }
        });

        ncert_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classes_layout.setVisibility(View.GONE);
                dictionary_layout.setVisibility(View.GONE);
                childrenbooks_layout.setVisibility(View.GONE);
                ncert_layout.setVisibility(View.VISIBLE);
            }
        });

        university_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Schoolbooks.this,Universitybooks.class);
                startActivity(i);
                finish();
            }
        });

        competitive_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Schoolbooks.this,Competitivebooks.class);
                startActivity(i);
                finish();
            }
        });


        fiction_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Schoolbooks.this,Fictionbooks.class);
                startActivity(i);
                finish();
            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(Schoolbooks.this,DividerItemDecoration.VERTICAL));

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
