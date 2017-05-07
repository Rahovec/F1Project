package com.example.rahovec.f1project;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lachezar on 5/7/2017.
 */

public class TrackDataAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public TrackDataAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


    public void add(Track_Data object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        Track_DataHolder track_dataHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.tracks_row, parent, false);
            track_dataHolder = new Track_DataHolder();
            track_dataHolder.trackname = (TextView) row.findViewById(R.id.trackname);
            track_dataHolder.trackcity = (TextView) row.findViewById(R.id.trackcity);
            track_dataHolder.trackcountry = (TextView) row.findViewById(R.id.trackcountry);
            row.setTag(track_dataHolder);
        }

        else{
            track_dataHolder = (Track_DataHolder) row.getTag();
        }

        Track_Data track_data = (Track_Data) this.getItem(position);
        track_dataHolder.trackname.setText(track_data.getName());
        track_dataHolder.trackcity.setText(track_data.getCity());
        track_dataHolder.trackcountry.setText(track_data.getCountry());


        return row;
    }

    static class Track_DataHolder{
        TextView trackname,trackcity,trackcountry;
    }
}
