package org.example.models;

import org.example.controller.ExpenseController;
import org.example.enums.ExpenseSplitType;
import org.example.split.Split;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private String groupID;
    private List<User> members;
    private List<Expense> expenseList;
    private UserBalanceSheet userBalanceSheet;

    private final ExpenseController expenseController;

    public Group(String groupName, String groupID) {
        this.groupName = groupName;
        this.groupID = groupID;
        this.expenseController = new ExpenseController();
        this.userBalanceSheet = new UserBalanceSheet();
        this.members = new ArrayList<>();
        this.expenseList = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public UserBalanceSheet getUserBalanceSheet(){
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }

    public Expense createExpense(String expenseID, String description, double amount, List<Split> splits, User paidBy, ExpenseSplitType splitType) {
        Expense expense = expenseController.createExpense(expenseID, description, amount, splits, paidBy, splitType);
        expenseList.add(expense);
        return expense; // Placeholder return statement
    }
}
