package org.example.strategies.expensestrategies;

import org.example.split.Split;

import java.util.List;

public interface IExpenseStrategy {
    void ValidateExpense(List<Split> splits, double amount);
}
