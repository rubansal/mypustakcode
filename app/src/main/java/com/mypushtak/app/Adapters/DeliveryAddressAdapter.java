package com.mypushtak.app.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mypushtak.app.R;

public class DeliveryAddressAdapter extends RecyclerView.Adapter<DeliveryAddressAdapter.ViewHolder> {

    private Context context;

    private String letters[];

    public DeliveryAddressAdapter(Context context, String[] letters) {
        this.context = context;

        this.letters = letters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.address_container,parent,false);

        return new DeliveryAddressAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.bookphoto.setImageResource(icons[position]);
        holder.address.setText(letters[position]);
    }

    @Override
    public int getItemCount() {
        return letters.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView address;
        private Button select,edit;

        public ViewHolder(View itemView) {
            super(itemView);

            address=itemView.findViewById(R.id.container_address);
            select=itemView.findViewById(R.id.container_select);
            edit=itemView.findViewById(R.id.container_edit);
        }
    }
}
