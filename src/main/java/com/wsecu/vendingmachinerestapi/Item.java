package com.wsecu.vendingmachinerestapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@JsonInclude
/**
 * Class representing an inventory item or a sale item
 */
public class Item {
    private String name;
    private int quantity;
    private BigDecimal price;

    Item(String n, int q, BigDecimal p){
        name = n;
        quantity = q;
        price = p;
    }
}
