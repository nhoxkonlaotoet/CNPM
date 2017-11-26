package com.example.administrator.cnpm.fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.cnpm.BL.BLProduct;
import com.example.administrator.cnpm.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    public List<Object> lstProduct;


    EditText txtSearch;
    Button btnSearch;
    ListView listView;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        txtSearch = (EditText)view.findViewById(R.id.txtSearch);
        listView = (ListView) view.findViewById(R.id.listProduct);
        BLProduct db = new BLProduct();
        lstProduct= db.LoadProduct();

        for(Object x : lstProduct ){
            try {
                Log.e(": ", (String) x.getClass().getField("id").get(x));
                Log.e(": ", (String) x.getClass().getField("name").get(x));
                Log.e(": ", x.getClass().getField("capacity").get(x).toString());
                Log.e(": ", x.getClass().getField("price").get(x).toString());

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
      //  Toast.makeText(getActivity(), +".", Toast.LENGTH_SHORT).show();

        //  listView.setItemsCanFocus(false);
        listView.setFocusable(false);



        ProductAdapter productAdapter = new ProductAdapter();

        listView.setAdapter(productAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                ProductDetailFragment nextFrag= new ProductDetailFragment();

                Bundle bundle = new Bundle();
        //        bundle.putSerializable("producttype", (Serializable) lstProduct.get(position));

                   nextFrag.setArguments(bundle);

                android.support.v4.app.FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contentLayout,nextFrag,"tag");
                fragmentTransaction.addToBackStack("tag");
                fragmentTransaction.commit();

                //show back button
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });
    }

    class ProductAdapter extends BaseAdapter {


        public ProductAdapter()
        {
        }
        @Override
        public int getCount() {

            return lstProduct.size();
        }

        @Override
        public Object getItem(int position) {
          return lstProduct.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getActivity().getLayoutInflater().inflate(R.layout.item_product,null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imgProduct);
            TextView txtName= (TextView)convertView.findViewById(R.id.txtName);
            TextView txtPrice= (TextView) convertView.findViewById(R.id.txtPrice);



            Drawable drawable = getResources().getDrawable(R.drawable.binh20l);
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            imageView.setImageBitmap(bitmap);
            try {
                String name = getItem(position).getClass().getField("name").get(getItem(position)).toString();
                String price= getItem(position).getClass().getField("price").get(getItem(position)).toString();

                txtName.setText(name);
                txtPrice.setText(price);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }


            return convertView;
        }
    }
}
