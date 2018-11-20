package com.mypushtak.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mypushtak.app.Activity.OrderDetails;
import com.mypushtak.app.R;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    private Context context;
    private  int icons[];
    private String letters[];

    public MyOrderAdapter(Context context, int[] icons, String[] letters) {
        this.context = context;
        this.icons = icons;
        this.letters = letters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_container,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookphoto.setImageResource(icons[position]);
        holder.orderdetail.setText(letters[position]);
        holder.orderdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, OrderDetails.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return letters.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView orderid,orderdate,deliveryby,mrp,shipping,cod,coupon,status,total,refundcost;
        private ImageView bookphoto;
        private Button thanks,orderdetail;
        public ViewHolder(View itemView) {
            super(itemView);

            orderid=itemView.findViewById(R.id.orders_orderid);
            orderdate=itemView.findViewById(R.id.orders_order_date);
            deliveryby=itemView.findViewById(R.id.orders_deliveryby);
            mrp=itemView.findViewById(R.id.orders_price);
            shipping=itemView.findViewById(R.id.orders_shipping);
            cod=itemView.findViewById(R.id.orders_cod);
            coupon=itemView.findViewById(R.id.orders_coupon);
            status=itemView.findViewById(R.id.orders_status);
            total=itemView.findViewById(R.id.orders_total);
            refundcost=itemView.findViewById(R.id.refund_mrp);
            bookphoto=itemView.findViewById(R.id.orders_book_image);
            thanks=itemView.findViewById(R.id.orders_thanks);
            orderdetail=itemView.findViewById(R.id.orders_order_details);



        }
    }
}
