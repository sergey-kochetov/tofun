package com.forfun.bootstrap;

import com.forfun.model.Author;
import com.forfun.model.Book;
import com.forfun.model.Publisher;
import com.forfun.repositories.AuthorRepository;
import com.forfun.repositories.BookRepository;
import com.forfun.repositories.PublisherRepository;
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
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher("publisher1", "town1");
        publisherRepository.save(publisher);

        // first
        Author author1 = new Author("name11", "name12");
        Book book1 = new Book("title1", "5634", publisher);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        //second
        Author author2 = new Author("name21", "name22");
        Book book2 = new Book("title2", "56343", publisher);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
