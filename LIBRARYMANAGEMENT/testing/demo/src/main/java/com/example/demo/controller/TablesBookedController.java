package com.example.demo.controller;

import com.example.demo.pojo.TablesBooked;
import com.example.demo.pojo.input.TablesBookedInput;

import com.example.demo.service.DefaultTablesBookedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class TablesBookedController {

    @Autowired
    private DefaultTablesBookedService tablesBookedService;

    @GetMapping("/tablesbooked")
    public List<TablesBooked> getAllTablesBooked() {
        return tablesBookedService.findAll();
    }

    @GetMapping("/tablesbooked/{tbID}")
    public TablesBooked getTablesBookedByTbId(@PathVariable Integer tbID) {
        return tablesBookedService.findTablesBookedByTbID(tbID);
    }

    @PostMapping("/tablesbooked")
    public TablesBooked insertNewTablesBooked(@RequestBody TablesBookedInput tablesBookedInput) {

        return tablesBookedService.save(tablesBookedInput);
    }

    @PutMapping("/tablesbooked/{tbID}")
    public TablesBooked updateTablesBooked(@PathVariable Integer tbID,
                                           @RequestBody TablesBookedInput tablesbookedInput) {


        return tablesBookedService.save(tablesbookedInput);
    }

    @DeleteMapping("/tablesbooked/{tbID}")
    public Boolean deleteTablesBooked(@PathVariable Integer tbID) {
        TablesBooked tablesbooked = tablesBookedService.findTablesBookedByTbID(tbID);
        tablesBookedService.delete(tbID);
        return true;

    }
}
