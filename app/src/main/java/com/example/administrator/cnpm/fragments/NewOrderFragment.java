package com.example.administrator.cnpm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.cnpm.R;
import com.example.administrator.cnpm.models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewOrderFragment extends Fragment {
    ListView listOrder;
    public NewOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listOrder = (ListView)getActivity().findViewById(R.id.listNewOrder);


        List<Order> list = new ArrayList<Order>();
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_order, container, false);
    }

    class OrderAdapter extends BaseAdapter {
        List<Order> list;
        public OrderAdapter(List<Order> list)
        {
            this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getActivity().getLayoutInflater().inflate(R.layout.item_order,null);

            TextView txtNumber= (TextView)convertView.findViewById(R.id.txtOrderNumber);
            TextView txtQuantity= (TextView) convertView.findViewById(R.id.txtQuantity);
            TextView txtCost = (TextView) convertView.findViewById(R.id.txtCost);
            TextView txtStatus = (TextView) convertView.findViewById(R.id.txtStatus);

            txtQuantity.setText("1");
            txtNumber.setText(list.get(position).id);
            txtCost.setText(list.get(position).cost.toString());
            txtStatus.setText(list.get(position).status);


            return convertView;
        }
    }
}
