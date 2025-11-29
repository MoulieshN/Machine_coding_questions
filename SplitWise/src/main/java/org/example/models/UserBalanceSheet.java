package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    private Map<String, Balance> balanceSheet;
    private double totalExpense;
    private double totalOwe;
    private double totalGetBack;
    private double totalPayments;

    public UserBalanceSheet() {
        this.balanceSheet = new HashMap<>();
        this.totalExpense = 0.0;
        this.totalOwe = 0.0;
        this.totalGetBack = 0.0;
        this.totalPayments = 0.0;
    }


    public Map<String, Balance> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Balance> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }
}
