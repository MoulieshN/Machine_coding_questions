package org.example.strategies.factories;

import org.example.enums.ExpenseSplitType;
import org.example.strategies.expensestrategies.EqualExpenseStrategy;
import org.example.strategies.expensestrategies.IExpenseStrategy;
import org.example.strategies.expensestrategies.PercentageExpenseStrategy;
import org.example.strategies.expensestrategies.UnEqualExpenseStrategy;

public class ExpenseFactory {
    public static IExpenseStrategy getExpenseStrategy(ExpenseSplitType expenseType) {
        return switch (expenseType) {
            case ExpenseSplitType.EQUAL -> new EqualExpenseStrategy();
            case ExpenseSplitType.NOT_EQUAL -> new UnEqualExpenseStrategy();
            case ExpenseSplitType.PERCENTAGE -> new PercentageExpenseStrategy();
            default -> throw new IllegalArgumentException("Invalid expense type: " + expenseType);
        };
    }
}
