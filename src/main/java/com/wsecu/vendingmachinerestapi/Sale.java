package com.wsecu.vendingmachinerestapi;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude
public class Sale {

    @JsonProperty("id")
    private int id;
    @JsonProperty("soda")
    private int soda;

    @JsonProperty("candy")
    private int candy;

    @JsonProperty("chips")
    private int chips;

    @JsonProperty("amount")
    private BigDecimal amount;
}
