package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongsAdapter extends BaseAdapter {
    private ArrayList<Songs> my_array;
    private LayoutInflater layoutInflater;

    public SongsAdapter(Context context, ArrayList<Songs> my_array) {
        this.my_array = my_array;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return  my_array.size();
    }

    @Override
    public Object getItem(int position) {
        return my_array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.song_item_activity, parent, false);
        }


        TextView text_name = (TextView)view.findViewById(R.id.name_txt);
        TextView text_author = (TextView)view.findViewById(R.id.author_txt);
        TextView text_duration = (TextView)view.findViewById(R.id.duration_txt);
        TextView text_year = (TextView)view.findViewById(R.id.year_txt);


        System.out.println(this.my_array.size());
        //System.out.println(map.get(0));
        text_name.setText(my_array.get(position).getName());
        text_author.setText(my_array.get(position).getAuthor());
        text_duration.setText(String.valueOf(my_array.get(position).getDuration()));
        text_year.setText(String.valueOf(my_array.get(position).getYear()));

        return view;

    }
}
