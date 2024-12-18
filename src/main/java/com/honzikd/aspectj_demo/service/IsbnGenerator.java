package com.honzikd.aspectj_demo.service;

import com.honzikd.aspectj_demo.annotations.TimeTracked;
import com.honzikd.aspectj_demo.repository.BookRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class IsbnGenerator {

    @TimeTracked
    public List<BookRecord> generate(List<BookRecord> inputBooks) {
        return inputBooks.stream()
                .map(book -> book.getIsbn() == null ? generateIsbn(book) : book)
                .toList();
    }

    private BookRecord generateIsbn(BookRecord book) {
        Random random = new Random();
        String isbn = String.format("abc-def-%d", random.nextInt());
        book.setIsbn(isbn);
        return book;
    }
}
