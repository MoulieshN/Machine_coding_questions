package org.example.states;

import org.example.VendingMachine;
import org.example.models.Item;

import java.util.Map;
import java.util.Scanner;

public class SelectProductState extends State{
    public SelectProductState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    public void chooseProduct() throws Exception{
        VendingMachine vendingMachine = this.getVendingMachine();
        Map<Integer, Item> inventory = vendingMachine.getInventory();
        for(Map.Entry<Integer, Item> entry : inventory.entrySet()){
            System.out.println("Code: " + entry.getKey() + ", Item: " + entry.getValue().type);
        }

        System.out.println("Enter the product code to select the product:");
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        Item selectedItem = vendingMachine.getItem(code);

        if(selectedItem == null){
            System.out.println("Invalid product code selected.");
            vendingMachine.setCurrentState(new IdleState(vendingMachine));
            return;
        }
        else if(selectedItem.quantity <= 0){
            System.out.println("Selected product is out of stock.");
            vendingMachine.setCurrentState(new IdleState(vendingMachine));
            return;
        }
        vendingMachine.setChosenItem(selectedItem);
        vendingMachine.setCurrentState(new HasMoneyState(vendingMachine));
    }
}
