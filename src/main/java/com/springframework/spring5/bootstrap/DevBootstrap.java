package com.springframework.spring5.bootstrap;

import com.springframework.spring5.model.Author;
import com.springframework.spring5.model.Book;
import com.springframework.spring5.repository.AuthorRepository;
import com.springframework.spring5.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        onInit();
    }

    private void onInit() {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Johnsons" );
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(noEJB);

    }
}
