package com.honzikd.aspectj_demo.service;


import com.honzikd.aspectj_demo.repository.BookRecord;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/books")
public interface DemoRestController {

    @GetMapping(value = "/all", produces = "application/json")
    List<BookRecord> getAll();

    @PostMapping
    BookRecord create(@RequestBody BookRecord bookRecord);

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id);

    @PutMapping("/{id}")
    Optional<BookRecord> update(@RequestBody BookRecord bookRecord);

    @GetMapping(value = "genIsbns", produces = "application/json")
    List<BookRecord> generateIsbns();
}
