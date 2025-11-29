package org.example.strategies.expensestrategies;

import org.example.split.Split;

import java.util.List;

public class EqualExpenseStrategy implements IExpenseStrategy{
    @Override
    public void ValidateExpense(List<Split> splits, double amount) {
        double individualShare = amount / splits.size();
        for(Split split : splits) {
            if(split.getAmount() != individualShare) {
                throw new IllegalArgumentException("Invalid split amount for equal expense");
            }
        }
    }
}
