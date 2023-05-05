package com.wsecu.vendingmachinerestapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonInclude
/**
 * Class maintaining all the sale transactions
 */
public class Transactions {

    private int counter = 0;
    @JsonProperty("sales")
    private List<Sale> sales = new ArrayList<Sale>();

    /**
     * Adds the new sale to the list of transactions
     * @param s The Sale to be recorded
     * @return Sale information with the unique sale transaction id
     */
    public Sale addSale(Sale s) {
        s.setId(++counter);
        sales.add(s);
        return s;
    }

    /**
     * Returns all the sales
     * @return list of sales
     */
    public List<Sale> getSales(){
        return sales;
    }

    /**
     * Returns the sale by sale transaction id
     * @param id the unique id of the sale
     * @return the Sale if found, null otherwise
     */
    public Sale getSaleById(int id) {
        if(id > sales.size() || id <=0) {
            return null;
        }
        else return sales.get(id-1);
    }

}
