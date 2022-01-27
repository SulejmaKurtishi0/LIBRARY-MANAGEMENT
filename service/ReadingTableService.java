package com.example.demo.service;

import com.example.demo.pojo.ReadingTable;
import com.example.demo.pojo.input.ReadingTableInput;

import java.util.List;

public interface ReadingTableService {
    List<ReadingTable> findAll();
    ReadingTable findReadingTableById(Integer id);
    ReadingTable save(ReadingTableInput readingtableInput);
    ReadingTable update(Integer id, ReadingTableInput readingtableInput);
    void delete(Integer id);
}
