package com.example.administrator.cnpm.models;

import java.util.Date;

/**
 * Created by Administrator on 25/11/2017.
 */

public class Product {
    public String id, status, type_Id;
    Date manufactureDate, expiryDate;
    public Product(){

    }
    public Product(String id, String status, Date manufactureDate, Date expiryDate, String type_Id)
    {
        this.id = id;
        this.status=status;
        this.type_Id=type_Id;
        this.manufactureDate=manufactureDate;
        this.expiryDate=expiryDate;
    }
}
