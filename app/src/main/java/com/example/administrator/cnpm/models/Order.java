package com.example.administrator.cnpm.models;

import java.util.Date;

public class Order {

    public String id, customerId, status;
    public Date time;
    public Integer cost;
    public Order(){

    }
    public Order(String id, Date time, Integer cost, String customerId, String status)
    {
        this.id=id;
        this.time=time;
        this.cost=cost;
        this.customerId=customerId;
        this.status=status;
    }
}
