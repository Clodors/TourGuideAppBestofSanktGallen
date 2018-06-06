package com.example.android.tourguideregionsanktgallen;

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
public class ZooFragment extends Fragment {

    private ArrayList<Location> locations;

    public ZooFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //prepare string resources in string array to fill the list
        String[] zoo = getActivity().getResources().getStringArray(R.array.attractions);
        String[] zooDesc = getActivity().getResources().getStringArray(R.array.zoo_desc);
        String[] zooLoc = getActivity().getResources().getStringArray(R.array.zoo_location);
        int[] imgSrc = {R.drawable.knies_kinderzoo, R.drawable.peter_and_paul,
                R.drawable.walter_zoo, R.drawable.greifvogelpark};
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.location_list, container, false);

        locations = new ArrayList<>();
        Location location;
        for (int i = 0; i < zoo.length; i++) {
            location = new Location(zoo[i], zooDesc[i], zooLoc[i], imgSrc[i]);
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

