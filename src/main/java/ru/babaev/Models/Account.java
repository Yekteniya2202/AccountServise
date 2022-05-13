package ru.babaev.Models;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class Account {
    @Expose
    public String card;
    @Expose
    public String name;
    @Expose
    public String lastName;
    @Expose
    public BigDecimal balance;


    public Account(){

    }
    public Account(String numberCard, String name, String lastName, BigDecimal  balance){
        this.lastName = lastName;
        this.name = name;
        this.card = numberCard;
        this.balance = balance;
    }

}
