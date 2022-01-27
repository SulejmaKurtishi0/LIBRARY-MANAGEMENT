package com.example.demo.service;


import com.example.demo.pojo.ReadingTable;

import com.example.demo.pojo.input.ReadingTableInput;

import com.example.demo.repository.ReadingTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultReadingTableService implements ReadingTableService{
    @Autowired
    private ReadingTableRepository readingTableRepository;

    @Override
    public List<ReadingTable> findAll() {
        return readingTableRepository.findAll();
    }

    @Override
    public ReadingTable findReadingTableById(Integer id) {
        return readingTableRepository.findReadingTableById(id);
    }

    @Override
    public ReadingTable save(ReadingTableInput readingTableInput) {


        String availability = readingTableInput.getAvailability();
        ReadingTable readingtable  = new ReadingTable();
        readingtable.setAvailability(availability);
        return readingTableRepository.save(readingtable);
    }

    @Override
    public ReadingTable update(Integer id, ReadingTableInput readingTableInput) {

        ReadingTable readingtable = readingTableRepository.findReadingTableById(id);
        if (readingtable == null) {
            return null;
        }

        String updatedAvailability = readingTableInput.getAvailability();


        readingtable.setAvailability(updatedAvailability);

        return readingTableRepository.save(readingtable);
    }

    @Override
    public void delete(Integer id) {
        ReadingTable readingTable= readingTableRepository.findReadingTableById(id);
        {
            if (readingTable!= null) {
                readingTableRepository.delete(readingTable);
            }
            readingTableRepository.delete(readingTable);
        }


    }
}