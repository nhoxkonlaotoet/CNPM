package com.example.administrator.cnpm.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.administrator.cnpm.R;
import com.example.administrator.cnpm.fragments.MapFragment;

public class MapsActivity extends FragmentActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.container_main);
        if(mapFragment==null)
        {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.container_main,mapFragment).commit();
        }
    }

}
