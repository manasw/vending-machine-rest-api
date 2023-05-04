package com.wsecu.vendingmachinerestapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonInclude
public class Inventory {

    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();

    Inventory() {
        items.add(new Item("Soda", 25, new BigDecimal("0.95")));
        items.add(new Item("Candy Bar", 25, new BigDecimal("0.60")));
        items.add(new Item("Chips", 25, new BigDecimal("0.99")));
    }


    public void decrementInventory(int soda, int candy, int chips){
        if(soda > 0) {
            Item item = items.get(0);
            item.setQuantity(item.getQuantity() - soda);
        }
        if(candy > 0) {
            Item item = items.get(1);
            item.setQuantity(item.getQuantity() - candy);

        }
        if (chips  > 0) {
            Item item = items.get(2);
            item.setQuantity(item.getQuantity() - chips);
        }
    }

}
