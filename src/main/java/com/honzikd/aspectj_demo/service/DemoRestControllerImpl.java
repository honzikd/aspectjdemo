package com.honzikd.aspectj_demo.service;

import com.honzikd.aspectj_demo.annotations.TimeTracked;
import com.honzikd.aspectj_demo.repository.BookRecord;
import com.honzikd.aspectj_demo.repository.DemoCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@Service
public class DemoRestControllerImpl implements DemoRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DemoCrudRepository repository;

    @Autowired
    IsbnGenerator isbnGenerator;

    @TimeTracked
    @Override
    public List<BookRecord> getAll() {
        return (List<BookRecord>) repository.findAll();
    }

    @Override
    public BookRecord create(BookRecord bookRecord) {
        return repository.save(bookRecord);
    }

    @Override
    public void delete(UUID id) {
        Optional<BookRecord> toDelete = repository.findById(id);
        if (toDelete.isPresent()) {
            repository.delete(toDelete.get());
        } else {
            logger.warn("BookRecord with id: '{}' does not exist.", id);
        }
    }

    @Override
    public Optional<BookRecord> update(BookRecord bookRecord) {
        UUID id = UUID.fromString(bookRecord.getId());
        Optional<BookRecord> toUpdate = repository.findById(id);
        if (toUpdate.isPresent()) {
            return Optional.of(repository.save(bookRecord));
        } else {
            logger.warn("BookRecord with id: '{}' does not exist.", id);
            return toUpdate;
        }
    }

    @Override
    public List<BookRecord> generateIsbns() {
        List<BookRecord> allBooks = (List<BookRecord>) repository.findAll();
        return isbnGenerator.generate(allBooks);
    }
}
