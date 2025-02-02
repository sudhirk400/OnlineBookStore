package com.sudhirk400.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Publisher;
import com.sudhirk400.bookstore.repository.PublisherRepository;

import java.util.List;

 
/**
 * The Class PublisherService.
 */
@Service
public class PublisherService {

    /** The publisher repository. */
    @Autowired
    private PublisherRepository publisherRepository;

    /**
     * Gets the all publishers.
     *
     * @return the all publishers
     */
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    /**
     * Gets the publisher by id.
     *
     * @param id the id
     * @return the publisher by id
     */
    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id).orElse(null);
    }

    /**
     * Save publisher.
     *
     * @param publisher the publisher
     * @return the publisher
     */
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    /**
     * Delete publisher by id.
     *
     * @param id the id
     */
    public void deletePublisherById(Integer id) {
        publisherRepository.deleteById(id);
    }
}
