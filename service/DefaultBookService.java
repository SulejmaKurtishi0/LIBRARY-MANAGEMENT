package com.example.demo.service;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.input.BookInput;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultBookService implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Integer id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Book save(BookInput bookInput) {


        String title = bookInput.getTitle();
        String author = bookInput.getAuthor();
        String availability= bookInput.getAvailability();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setAvailability(availability);

        return bookRepository.save(book);
    }

    @Override
    public Book update(Integer id, BookInput bookInput) {

        Book book = bookRepository.findBookById(id);

        if (book == null) {
            return null;
        }
        String updatedTitle = bookInput.getTitle();
        String updatedAuthor = bookInput.getAuthor();
        String updatedAvailability=bookInput.getAvailability();

        book.setTitle(updatedTitle);
        book.setAuthor(updatedAuthor);
        book.setAvailability(updatedAvailability);

        return bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        Book book= bookRepository.findBookById(id);
        {
            if (book!= null) {
                bookRepository.delete(book);
            }
            bookRepository.delete(book);
        }


    }
}
