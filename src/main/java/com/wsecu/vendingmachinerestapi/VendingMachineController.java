package com.wsecu.vendingmachinerestapi;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
/**
 * The Controller for the APIs
 */
public class VendingMachineController {

    Inventory inventory = new Inventory();
    Transactions transactions = new Transactions();


    @GetMapping("/inventory")
    /**
     * Return the inventory of the vending machine
     */
    public ResponseEntity<List<Item>> getInventory(){
        return ResponseEntity.ok(inventory.getInventory());
    }


    @GetMapping("/transactions")
    /**
     * Return all the sale transactions
     */
    public ResponseEntity<Transactions> getTransactions(){
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{id}")
    /**
     * Return the sale transaction for the requested id
     */
    public ResponseEntity getByTransactionId(@PathVariable int id){
        Sale s = transactions.getSaleById(id);
        if(s == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(s);
        }
    }

    @PostMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    /**
     * Capture a new sale transaction
     */
    public ResponseEntity<Sale> addSale(@RequestBody Sale s){
        Sale newSale = transactions.addSale(s);
        inventory.decrementInventory(s.getItems());
        return ResponseEntity.ok(newSale);
    }
}
