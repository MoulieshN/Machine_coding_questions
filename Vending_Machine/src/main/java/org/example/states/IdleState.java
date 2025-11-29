package org.example.states;

import org.example.VendingMachine;
import org.example.models.Item;

import java.util.ArrayList;

public class IdleState extends State {

    public IdleState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void clickOnSelectProductButton() {
        this.getVendingMachine().setCurrentState(new SelectProductState(this.getVendingMachine()));
    }

    @Override
    public void refillProducts() throws Exception {
        System.out.println("Refilling products...");
        VendingMachine vendingMachine = this.getVendingMachine();
        for(Item item : vendingMachine.getInventory().values()){
            // For simplicity, let's assume we refill each item to a quantity of 10
            item.quantity = 10;
            // update the inventory
            vendingMachine.getInventory().put(item.code, item);
        }
        System.out.println("All products refilled to quantity 10.");
    }
}
