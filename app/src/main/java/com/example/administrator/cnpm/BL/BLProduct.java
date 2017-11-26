package com.example.administrator.cnpm.BL;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.administrator.cnpm.DB.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BLProduct {
    DBConnect connectionDB = new DBConnect();
    Connection con = connectionDB.CONN();

    public ResultSet Load() {


        try {

            if (con == null) {
                return null;
            } else {
                //   String query = "select top 1 QuyenHan from TaiKhoan where SDT='" + userid + "'";
                String query ="select * from LoaiSanPham";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                return rs;

            }
        } catch (Exception ex) {
        }

        return null;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public List<Object> LoadProduct(){
        List<Object> lst = new ArrayList<Object>();
        try {

            if (con == null) {
                return null;
            } else {
                //   String query = "select top 1 QuyenHan from TaiKhoan where SDT='" + userid + "'";
                String query ="select * from LoaiSanPham";
                Statement stmt = con.createStatement();
                final ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new Object(){
                        public String id = rs.getString("MaLoai");
                        public String name = rs.getString("TenLoai");
                        public Float capacity = rs.getFloat("DungTich");
                        public Integer price = rs.getInt("Gia");
                    };
                    lst.add(obj);
                }
                return lst;
            }
        } catch (Exception ex) {
        }

        return null;
    }
}
