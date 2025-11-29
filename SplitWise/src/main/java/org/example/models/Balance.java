package org.example.models;

public class Balance {
    private double amountOwe;
    private double amountGetBack;

    public Balance() {
        this.amountOwe = 0.0;
        this.amountGetBack = 0.0;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public double getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }
}
