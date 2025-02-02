package com.sudhirk400.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Author;
import com.sudhirk400.bookstore.repository.AuthorRepository;

import java.util.List;

 
/**
 * The Class AuthorService.
 */
@Service
public class AuthorService {

    /** The author repository. */
    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Gets the all authors.
     *
     * @return the all authors
     */
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    /**
     * Gets the author by id.
     *
     * @param id the id
     * @return the author by id
     */
    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    /**
     * Save author.
     *
     * @param author the author
     * @return the author
     */
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    /**
     * Delete author by id.
     *
     * @param id the id
     */
    public void deleteAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }
}
