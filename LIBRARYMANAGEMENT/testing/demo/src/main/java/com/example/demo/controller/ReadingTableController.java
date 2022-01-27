package com.example.demo.controller;
import com.example.demo.pojo.ReadingTable;
import com.example.demo.pojo.input.ReadingTableInput;
import com.example.demo.service.DefaultReadingTableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReadingTableController {
    @Autowired
    private DefaultReadingTableService readingTableService;

    @GetMapping("/readingtable")
    public List<ReadingTable> getReadingTable() {
        return readingTableService.findAll();
    }

    @GetMapping("/readingtable/{id}")
    public ReadingTable getReadingTableById(@PathVariable Integer id) {
        return readingTableService.findReadingTableById(id);
    }

    @PostMapping("/readingtable")
    public ReadingTable insertNewReadingTable(@RequestBody ReadingTableInput readingTableInput) {
        return readingTableService.save(readingTableInput);
    }

    @PutMapping("/readingtable/{id}")
    public ReadingTable updateReadingTable(@PathVariable Integer id,
                                           @RequestBody ReadingTableInput readingTableInput) {
        return readingTableService.update(id,readingTableInput);
    }

    @DeleteMapping("/readingtble/{id}")
    public Boolean deleteReadingTable(@PathVariable Integer id) {
        readingTableService.delete(id);
        return true;
    }
}