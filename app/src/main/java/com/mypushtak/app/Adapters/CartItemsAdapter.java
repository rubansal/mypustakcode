package com.mypushtak.app.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mypushtak.app.R;


/*
 ****@author Anubhav Kumar
 * *****
 */

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder> {

    private Context context;
    private  int icons[];
    private String letters[];

    public CartItemsAdapter(Context context, int[] icons, String[] letters) {
        this.context = context;
        this.icons = icons;
        this.letters = letters;
    }

    @NonNull
    @Override
    public CartItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_container,parent,false);

        return new CartItemsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemsAdapter.ViewHolder holder, int position) {
        holder.book_image.setImageResource(icons[position]);
        holder.title.setText(letters[position]);
    }

    @Override
    public int getItemCount() {
        return letters.length;
    }



    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,mrp,shipping,qty;
        private ImageView book_image;
        private Button remove,wishlist;

        public ViewHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.cart_container_title);
            mrp=itemView.findViewById(R.id.cart_container_mrp);
            shipping=itemView.findViewById(R.id.cart_container_shipping);
            qty=itemView.findViewById(R.id.cart_container_qty);
            book_image=itemView.findViewById(R.id.cart_container_image);
            remove=itemView.findViewById(R.id.cart_container_remove);
            wishlist=itemView.findViewById(R.id.cart_container_wishlist);
        }
    }
}

