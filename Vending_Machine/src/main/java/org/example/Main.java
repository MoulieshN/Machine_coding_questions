package org.example;

import org.example.enums.ItemType;
import org.example.models.Item;
import org.example.strategies.CoinStrategy;
import org.example.strategies.PaymentStrategy;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        PaymentStrategy coinStrategy = new CoinStrategy();
        VendingMachine vendingMachine = new VendingMachine(coinStrategy);

        // items
        Item coke = new Item(1, ItemType.COKE, 10, 3, 20);
        Item pepsi = new Item(2, ItemType.PEPSI, 10, 10, 25);
        Item soda = new Item(3, ItemType.SODA, 10, 10, 30);

        vendingMachine.getInventory().put(coke.code, coke);
        vendingMachine.getInventory().put(pepsi.code, pepsi);
        vendingMachine.getInventory().put(soda.code, soda);

        System.out.println("Vending Machine is ready to use!");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==================== Vending Machine ====================");
            vendingMachine.getCurrentState().clickOnSelectProductButton();
            vendingMachine.getCurrentState().chooseProduct();
            vendingMachine.getCurrentState().insertCoin();
            vendingMachine.getCurrentState().dispenseProduct();

            System.out.println("Do you want to continue? (yes/no)");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("no")) {
                System.out.println("Thank you for using the Vending Machine!");
                break;
            }
        }
    }
}