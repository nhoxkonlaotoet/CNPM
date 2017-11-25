package com.example.administrator.cnpm.BL;

import com.example.administrator.cnpm.DB.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 25/11/2017.
 */

public class BLLogin {
    DBConnect connectionDB = new DBConnect();
    Connection   con = connectionDB.CONN();

    public Boolean Login(String userid, String password) {
        try {

            if (con == null) {
               return false;
            } else {
                String query = "select * from TaiKhoan where SDT='" + userid + "' and MatKhau='" + password + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {

                   return true;

                } else {
                    return false;
                }

            }
        } catch (Exception ex) {

        }
        return false;
    }

}
