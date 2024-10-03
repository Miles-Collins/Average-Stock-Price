package com.main;

import java.text.DecimalFormat;

public class Stock {

    public int shares;
    private double price;
    private double capital;
    DecimalFormat df = new DecimalFormat("0.00");

    public void buy(double s, double p) {
        shares += s;
        price = p;
        capital += s * p;
    }

    public void sell(double s, double p) {
        shares -= p;
        price = p;
        capital -= s * p;
    }

    public String getCapital() {
        return df.format(capital);
    }

    public String getShares() {
        return df.format(shares);
    }

    public double getAveragePrice() {
        return capital / shares;
    }
}
