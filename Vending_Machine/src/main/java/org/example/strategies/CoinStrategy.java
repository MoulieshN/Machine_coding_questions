package org.example.strategies;

import java.util.Scanner;

public class CoinStrategy implements PaymentStrategy {
    public CoinStrategy() {
    }
    @Override
    public double pay() {
        System.out.println("Payment made using Coins.");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        return amount;
    }
}
