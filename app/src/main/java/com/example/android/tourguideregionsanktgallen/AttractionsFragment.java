package com.example.android.tourguideregionsanktgallen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {

    private ArrayList<Location> locations;

    public AttractionsFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //prepare string resources in string array to fill the list
        String[] attractions = getActivity().getResources().getStringArray(R.array.attractions);
        String[] attractionsDesc = getActivity().getResources().getStringArray(R.array.attractions_desc);
        String[] attractionsLoc = getActivity().getResources().getStringArray(R.array.attractions_location);
        int[] imgSrc = {R.drawable.abbey_library, R.drawable.fuerstabtei,
                R.drawable.kathedrale, R.drawable.wooden_bridge_from_rapperswil_to_hurden, R.drawable.forum_wuerth};
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.location_list, container, false);

        locations = new ArrayList<>();
        Location location;
        for (int i = 0; i < attractions.length; i++) {
            location = new Location(attractions[i], attractionsDesc[i], attractionsLoc[i], imgSrc[i]);
            locations.add(location);
            Log.v("", location.toString());
        }
        ListView locationListView = view.findViewById(R.id.location_list_view);
        LocationListAdapter adapter = new LocationListAdapter(getActivity().getApplicationContext(), locations);
        locationListView.setAdapter(adapter);
        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Location clickedLocation = locations.get(position);
                String loc = clickedLocation.getLocationLoc();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(loc)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("LOCATION");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }

}