package com.example.demo.service;

import com.example.demo.pojo.Member;
import com.example.demo.pojo.PublishingHouse;
import com.example.demo.pojo.input.MemberInput;
import com.example.demo.pojo.input.PublishingHouseInput;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultPublishingHouseService implements PublishingHouseService{
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;

    @Override
    public List<PublishingHouse> findAll() {
        return publishingHouseRepository.findAll();
    }

    @Override
    public PublishingHouse findPublishingHouseById(Integer id) {
        return publishingHouseRepository.findPublishingHouseById(id);
    }

    @Override
    public PublishingHouse save(PublishingHouseInput publishingHouseInput) {


        String name = publishingHouseInput.getName();
        String address = publishingHouseInput.getAddress();
        Integer nrbooks= publishingHouseInput.getNrBooks();

        PublishingHouse publishinghouse = new PublishingHouse();
        publishinghouse.setName(name);
        publishinghouse.setAddress(address);
        publishinghouse.setNrBooks(nrbooks);

        return publishingHouseRepository.save(publishinghouse);
    }

    @Override
    public PublishingHouse update(Integer id, PublishingHouseInput publishingHouseInput) {

        PublishingHouse publishinghouse = publishingHouseRepository.findPublishingHouseById(id);
        if (publishinghouse== null) {
            return null;
        }

        String updatedName = publishingHouseInput.getName();
        String updatedAddress =  publishingHouseInput.getAddress();
        Integer updatedNrBooks = publishingHouseInput.getNrBooks();

        publishinghouse.setName(updatedName);
        publishinghouse.setAddress(updatedAddress);
        publishinghouse.setNrBooks(updatedNrBooks);

        return publishingHouseRepository.save(publishinghouse);
    }

    @Override
    public void delete(Integer id) {
        PublishingHouse publishingHouse= publishingHouseRepository.findPublishingHouseById(id);
        {
            if (publishingHouse!= null) {
                publishingHouseRepository.delete(publishingHouse);
            }
            publishingHouseRepository.delete(publishingHouse);
        }


    }
}
