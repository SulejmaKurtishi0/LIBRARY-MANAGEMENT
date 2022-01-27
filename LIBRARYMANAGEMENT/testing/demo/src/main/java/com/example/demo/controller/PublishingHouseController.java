package com.example.demo.controller;
import com.example.demo.pojo.PublishingHouse;

import com.example.demo.pojo.input.PublishingHouseInput;

import com.example.demo.service.DefaultPublishingHouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PublishingHouseController {
    @Autowired
    private DefaultPublishingHouseService publishingHouseService;

    @GetMapping("/publishinghouse")
    public List<PublishingHouse> getPublishingHouse() {
        return publishingHouseService.findAll();
    }

    @GetMapping("/publishinghosue/{id}")
    public PublishingHouse getPublishingHouseById(@PathVariable Integer id) {
        return publishingHouseService.findPublishingHouseById(id);
    }

    @PostMapping("/publishinghouse")
    public PublishingHouse insertNewPublishingHouse(@RequestBody PublishingHouseInput publishingHouseInput) {
        return publishingHouseService.save(publishingHouseInput);
    }

    @PutMapping("/publishinghouse/{id}")
    public PublishingHouse updatePublishingHouse(@PathVariable Integer id,
                                                 @RequestBody PublishingHouseInput publishingHouseInput) {
        return publishingHouseService.update(id,publishingHouseInput);
    }

    @DeleteMapping("/publishinghouse/{id}")
    public Boolean deletePublishingHouse(@PathVariable Integer id) {
        publishingHouseService.delete(id);
        return true;
    }
}
