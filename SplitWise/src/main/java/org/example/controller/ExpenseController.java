package org.example.controller;

import org.example.enums.ExpenseSplitType;
import org.example.models.Expense;
import org.example.models.User;
import org.example.split.Split;
import org.example.strategies.expensestrategies.IExpenseStrategy;
import org.example.strategies.factories.ExpenseFactory;

import java.util.List;

public class ExpenseController {

    private BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseID, String description, double amount, List<Split> splits, User paidBy, ExpenseSplitType splitType) {
        // Implementation for creating an expense
        IExpenseStrategy expenseStrategy = ExpenseFactory.getExpenseStrategy(splitType);
        expenseStrategy.ValidateExpense(splits, amount);
        Expense expense =  new Expense(expenseID, amount, description, paidBy, splitType, splits);
        balanceSheetController.updateBalanceSheet(splits, paidBy, amount);
        return expense;
    }
}
