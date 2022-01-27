package com.example.demo.repository;

import com.example.demo.pojo.PublishingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Integer> {
    List<PublishingHouse> findAll();

    PublishingHouse findPublishingHouseById(Integer id);
}