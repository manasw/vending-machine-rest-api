package com.wsecu.vendingmachinerestapi;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonInclude
/**
 * Class representing a sale transaction
 */
public class Sale {

    @JsonProperty("id")
    private int id;

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("amount")
    private BigDecimal amount;

}
