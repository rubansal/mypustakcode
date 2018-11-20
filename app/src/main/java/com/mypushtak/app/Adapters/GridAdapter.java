package com.mypushtak.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mypushtak.app.Activity.productfullview;
import com.mypushtak.app.R;

public class GridAdapter extends BaseAdapter {


    private  int icons[];
    private String letters[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, int[] icons, String[] letters ) {
        this.icons = icons;
        this.letters = letters;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return letters.length;
    }

    @Override
    public Object getItem(int position)
    {
        return letters[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent)
    {
        View gridview =convertview;

        if (convertview==null)
        {
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridview=inflater.inflate(R.layout.custom_lyout,null);
        }

        ImageView icon=gridview.findViewById(R.id.g1);
        TextView letter=(TextView)gridview.findViewById(R.id.txt);

        icon.setImageResource(icons[position]);
        letter.setText(letters[position]);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,productfullview.class);
                context.startActivity(i);
            }
        });
        return gridview;
    }
}



