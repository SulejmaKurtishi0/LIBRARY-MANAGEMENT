package com.example.demo.repository;

import com.example.demo.pojo.TablesBooked;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface TablesBookedRepository extends CrudRepository<TablesBooked, Integer> {
    List<TablesBooked> findAll();
    TablesBooked findTablesBookedByTbID(Integer tbID);
}
