package com.example.springfreemaker.model;


import java.math.BigInteger;

public class DataSet
{
    private BigInteger id;
    private String name;

    public DataSet(BigInteger id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters and setters

    @Override
    public String toString() {
        return "DataSet [id=" + id + ", name=" + name + "]";
    }
}

