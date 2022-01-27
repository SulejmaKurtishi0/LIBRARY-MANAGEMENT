package com.example.demo.repository;

import com.example.demo.pojo.ReadingTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingTableRepository extends CrudRepository<ReadingTable, Integer> {
    List<ReadingTable> findAll();

    ReadingTable findReadingTableById(Integer id);
}