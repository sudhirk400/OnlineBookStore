package com.sudhirk400.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Publisher;
import com.sudhirk400.bookstore.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Integer id) {
        publisherRepository.deleteById(id);
    }
}
