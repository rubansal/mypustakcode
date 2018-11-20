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

public class Competitivebooks extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView engandmed_image;
    ImageView government_image;
    ImageView international_image;
    ImageView schoollevel_image;

    ImageView school_image;
    ImageView university_image;
    ImageView fiction_image;

    ImageView home_icon;

    DrawerLayout drawerLayout;

    LinearLayout engineeringbooks_layout;
    LinearLayout governmentjobs_layout;
    LinearLayout internationalexams_layout;
    LinearLayout schoollevel_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitivebooks);

        engandmed_image=findViewById(R.id.engandmed_image);
        government_image=findViewById(R.id.government_image);
        international_image=findViewById(R.id.international_image);
        schoollevel_image=findViewById(R.id.schoollevel_image);

        home_icon=findViewById(R.id.home_icon);

        school_image=findViewById(R.id.school_image);
        university_image=findViewById(R.id.university_image);
        fiction_image=findViewById(R.id.fiction_image);

        engineeringbooks_layout=findViewById(R.id.engineeringbooks_layout);
        governmentjobs_layout=findViewById(R.id.governmentjobs_layout);
        internationalexams_layout=findViewById(R.id.internationalexams_layout);
        schoollevel_layout=findViewById(R.id.schoollevel_layout);

        engandmed_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                governmentjobs_layout.setVisibility(View.GONE);
                internationalexams_layout.setVisibility(View.GONE);
                schoollevel_layout.setVisibility(View.GONE);
                engineeringbooks_layout.setVisibility(View.VISIBLE);
            }
        });

        government_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engineeringbooks_layout.setVisibility(View.GONE);
                internationalexams_layout.setVisibility(View.GONE);
                schoollevel_layout.setVisibility(View.GONE);
                governmentjobs_layout.setVisibility(View.VISIBLE);
            }
        });

        international_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engineeringbooks_layout.setVisibility(View.GONE);
                governmentjobs_layout.setVisibility(View.GONE);
                schoollevel_layout.setVisibility(View.GONE);
                internationalexams_layout.setVisibility(View.VISIBLE);
            }
        });

        schoollevel_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engineeringbooks_layout.setVisibility(View.GONE);
                governmentjobs_layout.setVisibility(View.GONE);
                internationalexams_layout.setVisibility(View.GONE);
                schoollevel_layout.setVisibility(View.VISIBLE);
            }
        });

        school_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Competitivebooks.this,Schoolbooks.class);
                startActivity(i);
                finish();
            }
        });

        university_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Competitivebooks.this,Universitybooks.class);
                startActivity(i);
                finish();
            }
        });


        fiction_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Competitivebooks.this,Fictionbooks.class);
                startActivity(i);
                finish();
            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(Competitivebooks.this,DividerItemDecoration.VERTICAL));

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
