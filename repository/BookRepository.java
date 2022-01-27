package com.example.demo.repository;

import com.example.demo.pojo.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer> {
    List<Book> findAll();
    Book findBookById(Integer id);
}
