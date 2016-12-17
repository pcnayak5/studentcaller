package com.example.prashanthc.call_activity;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] contacts;
    //private final String[] phone;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] contacts, Integer[] imgid) {
        super(context, R.layout.rows, contacts);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.contacts=contacts;
        this.imgid=imgid;
        //this.phone=phone;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.rows, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        //TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

       txtTitle.setText(contacts[position]);
        imageView.setImageResource(imgid[position]);
        //extratxt.setText("Description "+phone[position]);
        return rowView;

    }
}
