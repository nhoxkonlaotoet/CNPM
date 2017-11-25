package com.example.administrator.cnpm.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.administrator.cnpm.R;
import com.example.administrator.cnpm.fragments.MapFragment;
import com.example.administrator.cnpm.fragments.NewOrderFragment;
import com.example.administrator.cnpm.fragments.ProductFragment;

public class MainActivity extends AppCompatActivity {

    Boolean isCustomer;
    Toolbar toolbar;
    TextView segNew, segHisttory;
    TableLayout segment;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            segment.setVisibility(View.INVISIBLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            FragmentManager manager =getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(isCustomer){
                        setTitle("Sản phẩm");
                        ProductFragment fragment = new ProductFragment();
                        manager.beginTransaction().replace(R.id.contentLayout,fragment,fragment.getTag()).commit();
                    }
                    else
                    {
                        setTitle("Giao hàng");
                        MapFragment fragment = new MapFragment();
                        manager.beginTransaction().replace(R.id.contentLayout,fragment,fragment.getTag()).commit();
                    }
                    return true;
                case R.id.navigation_order:
                    setTitle(null);
                    segment.setVisibility(View.VISIBLE);
                    segNew.callOnClick();
                    return true;
                case R.id.navigation_information:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_setting:
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        segment= (TableLayout)findViewById(R.id.segment);
        segNew= (TextView)findViewById(R.id.segNew);
        segHisttory= (TextView)findViewById(R.id.segHistory);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar= (Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        segment.setVisibility(View.INVISIBLE);


        Intent callerIntent=getIntent();
        //có intent rồi thì lấy Bundle dựa vào MyPackage
        isCustomer= callerIntent.getBooleanExtra("isCustomer",true);
        Log.e("là khách: ",isCustomer.toString());

        navigation.setSelectedItemId(R.id.navigation_home);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // nếu sử dụng popbackstack thì lưu thao tác cũ của fragment
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);

                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack("tag",1);

                } else {
                    onBackPressed();
                }
            }
        });
        segNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segNew.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                segNew.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorWhite));
                segHisttory.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorWhite));
                segHisttory.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark));

                NewOrderFragment newOrderFragment = new NewOrderFragment();
                FragmentManager manager =getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.contentLayout,newOrderFragment,newOrderFragment.getTag()).commit();
            }
        });
        segHisttory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segHisttory.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                segHisttory.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorWhite));
                segNew.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorWhite));
                segNew.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark));
//                OrderHistoryFragment orderHistoryFragment = new OrderHistoryFragment();
//                android.app.FragmentManager manager= getFragmentManager();
//                manager.beginTransaction().replace(R.id.contenLayout,orderHistoryFragment,orderHistoryFragment.getTag()).commit();
            }
        });
    }

}
