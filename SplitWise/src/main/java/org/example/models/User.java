package org.example.models;

public class User {
    private String name;
    private String userID;
    private UserBalanceSheet userBalanceSheet;

    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.userBalanceSheet = new UserBalanceSheet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }
}
