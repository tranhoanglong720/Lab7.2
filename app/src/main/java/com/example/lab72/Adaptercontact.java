package com.example.lab72;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class Adaptercontact extends BaseAdapter {
    private MainActivity context;
    private int Layout;
    private List<Contact> listcontact;
    private ImageButton btnxoa,btnsua;
    public Adaptercontact(MainActivity context, int layout, List<Contact> listcontact) {
        this.context = context;
        Layout = layout;
        this.listcontact = listcontact;
    }
    @Override
    public int getCount() {
        return listcontact.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if(listcontact.size()!=0 || listcontact.isEmpty())
        {
            view = LayoutInflater.from(parent.getContext()).inflate(Layout,parent,false);
        }
        TextView txtten=(TextView) view.findViewById(R.id.txtten);
        btnxoa=(ImageButton) view.findViewById(R.id.btnxoa);
        btnsua=(ImageButton) view.findViewById(R.id.btnsua);
        final Contact c=listcontact.get(i);
        txtten.setText(c._name);
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.XoaDongdachon(c._id);
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.Suadongdachon(c._name,c._id);
            }
        });
        return view;
    }


}
