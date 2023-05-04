package com.wsecu.vendingmachinerestapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonInclude
public class Transactions {

    private int counter = 0;
    @JsonProperty("sales")
    private List<Sale> sales = new ArrayList<Sale>();

    public Sale addSale(Sale s) {
        s.setId(++counter);
        sales.add(s);
        return s;
    }

    public List<Sale> getSales(){
        return sales;
    }

    public Sale getSaleById(int i) {
        if(i > sales.size()) {
            return null;
        }
        else return sales.get(i-1);
    }

}
