package com.example.administrator.cnpm.fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.Toast;

import com.example.administrator.cnpm.BL.BLProduct;
import com.example.administrator.cnpm.R;
import com.example.administrator.cnpm.models.A;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        txtSearch = (EditText)view.findViewById(R.id.txtSearch);
        listView = (ListView) view.findViewById(R.id.listProduct);
        BLProduct db = new BLProduct();
        String name = db.TypeName();

        Toast.makeText(getActivity(), name+".", Toast.LENGTH_SHORT).show();
        List<A> list = new ArrayList<A>();
        //  listView.setItemsCanFocus(false);
        listView.setFocusable(false);

        Drawable drawable = getResources().getDrawable(R.drawable.binh20l);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

        list.add(new A("Bình nước 20L",bitmap,15000));
        list.add(new A("Bình nước 5L",bitmap,20000));
        list.add(new A("Chai nước 1L",bitmap,10000));
        list.add(new A("Chai nước 330ml",bitmap,3000));

        ProductAdapter productAdapter = new ProductAdapter();

        listView.setAdapter(productAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                ProductDetailFragment nextFrag= new ProductDetailFragment();

                Bundle bundle = new Bundle();
                bundle.putString("key","abc"); // Put anything what you want
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

            return 0;
        }

        @Override
        public Object getItem(int position) {
          return null;
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
            TextView txtCost= (TextView) convertView.findViewById(R.id.txtCost);

            imageView.setImageBitmap(null);
            txtName.setText("1");
            txtCost.setText("10000đ");

            return convertView;
        }
    }
}
