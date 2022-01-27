package com.example.demo.service;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.ReadingTable;

import com.example.demo.pojo.TablesBooked;
import com.example.demo.pojo.input.TablesBookedInput;

import com.example.demo.repository.TablesBookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTablesBookedService implements TablesBookedService{
    @Autowired
    private TablesBookedRepository tablesBookedRepository;

    @Override
    public List<TablesBooked> findAll() {
        return tablesBookedRepository.findAll();
    }

    @Override
    public TablesBooked findTablesBookedByTbID(Integer tbID) {
        return tablesBookedRepository.findTablesBookedByTbID(tbID);
    }

    @Override
    public TablesBooked save(TablesBookedInput tablesBookedInput) {


        Book book = tablesBookedInput.getBook();
        ReadingTable readingtable = tablesBookedInput.getReadingtable();


        TablesBooked tablesbooked= new TablesBooked();
        tablesbooked.setBook(book);
        tablesbooked.setReadingtable(readingtable);

        return tablesBookedRepository.save(tablesbooked);
    }

    @Override
    public TablesBooked update(Integer tbID, TablesBookedInput tablesBookedInput) {

        TablesBooked tablesbooked = tablesBookedRepository.findTablesBookedByTbID(tbID);
        if (tablesbooked == null) {
            return null;
        }

        Book updatedbook = tablesBookedInput.getBook();
        ReadingTable updatedreadingtable = tablesBookedInput.getReadingtable();


        tablesbooked.setBook(updatedbook);
        tablesbooked.setReadingtable(updatedreadingtable);


        return  tablesBookedRepository.save(tablesbooked);
    }

    @Override
    public void delete(Integer tbID) {
        TablesBooked tablesbooked= tablesBookedRepository.findTablesBookedByTbID(tbID);
        {
            if (tablesbooked!= null) {
                tablesBookedRepository.delete(tablesbooked);
            }
            tablesBookedRepository.delete(tablesbooked);
        }


    }
}
