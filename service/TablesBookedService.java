package com.example.demo.service;

import com.example.demo.pojo.TablesBooked;
import com.example.demo.pojo.input.TablesBookedInput;

import java.util.List;

public interface TablesBookedService {
    List<TablesBooked> findAll();
    TablesBooked findTablesBookedByTbID(Integer tbID);
    TablesBooked save(TablesBookedInput tablesbookedInput);
    TablesBooked update(Integer tbID, TablesBookedInput tablesbookedInput);
    void delete(Integer tbID);
}
