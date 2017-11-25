package com.example.administrator.cnpm.BL;

import com.example.administrator.cnpm.DB.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    public String TypeName(){
        try {

            if (con == null) {
                return null;
            } else {
                //   String query = "select top 1 QuyenHan from TaiKhoan where SDT='" + userid + "'";
                String query ="select * from LoaiSanPham";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    return rs.getString("TenLoai");
                } else {
                    return null;
                }


            }
        } catch (Exception ex) {
        }

        return null;
    }
}
