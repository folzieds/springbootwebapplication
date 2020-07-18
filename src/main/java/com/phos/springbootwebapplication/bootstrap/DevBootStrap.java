package com.phos.springbootwebapplication.bootstrap;

import com.phos.springbootwebapplication.model.Author;
import com.phos.springbootwebapplication.model.Book;
import com.phos.springbootwebapplication.model.Publisher;
import com.phos.springbootwebapplication.repositories.AuthorRepository;
import com.phos.springbootwebapplication.repositories.BookRepository;
import com.phos.springbootwebapplication.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Author eric = new Author("Eric","Evans");
        Publisher harper = new Publisher("Harper Collins");
        Book ddd = new Book("Domain Driven Design","1234",harper);
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);



        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx");
        Book noEJB = new Book("J2EE Development without EJB", "23444",worx);
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
