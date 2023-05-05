package com.wsecu.vendingmachinerestapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Class that maintains inventory along with methods to get and update inventory
 */
public class Inventory {

    private Map<String, Item> items = new HashMap<String, Item>();

    //Constructor that initializes the inventory items
    Inventory() {
        items.put("Soda", new Item("Soda", 25, new BigDecimal("0.95")));
        items.put("Candy Bar", new Item("Candy Bar", 25, new BigDecimal("0.60")));
        items.put("Chips", new Item("Chips", 25, new BigDecimal("0.99")));
    }

    /**
     * Returns the inventory items
     * @return List of items in the inventory
     */
    public List<Item> getInventory() {
        return new ArrayList<Item>(items.values());
    }


    /**
     * Adjusts the inventory count of the items
     * @param saleItems List of items representing the reduction in inventory count
     */
    public void decrementInventory(List<Item> saleItems){
        if(saleItems == null) {
            return;
        }
        for(int i = 0; i < saleItems.size(); i++) {
            Item saleItem = saleItems.get(i);
            Item inventoryItem = items.get(saleItem.getName());
            if(inventoryItem != null) {
                inventoryItem.setQuantity(inventoryItem.getQuantity() - saleItem.getQuantity());
                items.put(inventoryItem.getName(), inventoryItem);
            }
        }
    }

}
