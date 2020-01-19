package com.springframework.spring5.bootstrap;

import com.springframework.spring5.model.Author;
import com.springframework.spring5.model.Book;
import com.springframework.spring5.model.Publisher;
import com.springframework.spring5.repository.AuthorRepository;
import com.springframework.spring5.repository.BookRepository;
import com.springframework.spring5.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        onInit();
    }

    private void onInit() {
        Publisher p1 = new Publisher("Pub 1", "1234, Somewhere");
        publisherRepository.save(p1);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "Harper Collins");
        ddd.setPublisher(p1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher p2 = new Publisher("Pub 2", "223344, Somehere");
        publisherRepository.save(p2);

        Author rob = new Author("Rob", "Johnsons" );
        Book noEJB = new Book("J2EE Development without EJB", "Worx");
        noEJB.setPublisher(p2);
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(noEJB);

    }
}
