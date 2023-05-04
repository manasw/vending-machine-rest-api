package com.wsecu.vendingmachinerestapi;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VendingMachineController {

    Inventory inventory = new Inventory();
    Transactions transactions = new Transactions();


    @GetMapping("/inventory")
    public ResponseEntity<Inventory> getInventory(){
        return ResponseEntity.ok(inventory);
    }


    @GetMapping("/transactions")
    public ResponseEntity<Transactions> getTransactions(){
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{id}")
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
    public ResponseEntity<Sale> addSale(@RequestBody Sale s){
        Sale newSale = transactions.addSale(s);
        inventory.decrementInventory(s.getSoda(), s.getCandy(), s.getChips());
        return ResponseEntity.ok(newSale);
    }
}
