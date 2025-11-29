package org.example.models;

import org.example.enums.ExpenseSplitType;
import org.example.split.Split;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String expenseID;
    private String description;
    private double amount;
    private User paidBy;
    private ExpenseSplitType splitType;
    private List<Split> splits = new ArrayList<>();

    public Expense(String expenseId, double expenseAmount, String description,
                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {

        this.expenseID = expenseId;
        this.amount = expenseAmount;
        this.description = description;
        this.paidBy = paidByUser;
        this.splitType = splitType;
        this.splits.addAll(splitDetails);

    }

}
