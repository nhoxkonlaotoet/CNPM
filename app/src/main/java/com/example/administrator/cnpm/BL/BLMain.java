package com.example.administrator.cnpm.BL;

import com.example.administrator.cnpm.DB.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 25/11/2017.
 */

public class BLMain {

    DBConnect connectionDB = new DBConnect();
    Connection  con = connectionDB.CONN();
    public BLMain(){

    }


    public String getRole(String userid) {
        String r="";

        try {

            if (con == null) {
                return "Không có kết nối";
            } else {
                //   String query = "select top 1 QuyenHan from TaiKhoan where SDT='" + userid + "'";
                String query ="select QuyenHan from TaiKhoan where SDT='099999999'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {

                    r= rs.getString("QuyenHan");

                } else {

                }

            }
        } catch (Exception ex) {

        }
        return r;
    }
}
