package org.example.states;

import org.example.VendingMachine;
import org.example.models.Item;

public class DispenseState extends  State {
    public DispenseState(VendingMachine vendingMachine) throws Exception {
        super(vendingMachine);
    }

    public void dispenseProduct() throws Exception{
        VendingMachine vendingMachine = this.getVendingMachine();
        Item item = vendingMachine.getChosenItem();
        System.out.println("Dispensed product: " + item.type + ". Remaining quantity: " + (item.quantity - 1));
        vendingMachine.getInventory().get(item.code).quantity -=1;
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
    }
}
