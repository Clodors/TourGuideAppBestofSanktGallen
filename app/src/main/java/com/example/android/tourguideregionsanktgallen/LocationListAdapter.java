package com.example.android.tourguideregionsanktgallen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class LocationListAdapter extends ArrayAdapter<Location> {
    private Context context;
    public LocationListAdapter(@NonNull Context context, ArrayList<Location> location) {
        super(context, 0, location);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View locationItemView = convertView;
        ViewHolder holder;
        if (locationItemView == null) {
            locationItemView = LayoutInflater.from(context).inflate(R.layout.location_item, parent, false);
            holder = new ViewHolder(locationItemView);
            locationItemView.setTag(holder);
        } else {
            holder = (ViewHolder) locationItemView.getTag();
        }
        Log.v("", holder.toString());
        Location location = getItem(position);
        int img_src_id;
        if (location != null) {
            holder.locationNameText.setText(location.getLocationName());
            holder.locationDescText.setText(location.getLocationDesc());
            img_src_id = location.getLocationImage();
            if (img_src_id > 0) {
                holder.locationImage.setImageResource(img_src_id);
            } else {
                holder.locationImage.setVisibility(View.GONE);
            }
        }
        return locationItemView;
    }

    static class ViewHolder {
        @BindView(R.id.location_image)
        ImageView locationImage;
        @BindView(R.id.location_name_text)
        TextView locationNameText;
        @BindView(R.id.location_desc_text)
        TextView locationDescText;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "locationImage=" + locationImage +
                    ", locationNameText=" + locationNameText +
                    ", locationDescText=" + locationDescText +
                    '}';
        }
    }
}