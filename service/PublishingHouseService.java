package com.example.demo.service;

import com.example.demo.pojo.PublishingHouse;
import com.example.demo.pojo.input.PublishingHouseInput;

import java.util.List;

public interface PublishingHouseService {
    List<PublishingHouse> findAll();
    PublishingHouse findPublishingHouseById(Integer id);
    PublishingHouse save(PublishingHouseInput publishinghouseInput);
    PublishingHouse update(Integer id, PublishingHouseInput publishinghouseInput);
    void delete(Integer id);
}
