package cz.honzikd.aspectj_demo;

import cz.honzikd.aspectj_demo.annotations.TimeTracked;
import cz.honzikd.aspectj_demo.repository.BookRecord;
import cz.honzikd.aspectj_demo.repository.DemoCrudRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

@SpringBootTest
public class TestData {

    private static final int COUNT = 100000;

    @Autowired
    DemoCrudRepository repository;

    @TimeTracked
    @Test
    public void createTestBookRecords() throws IOException {

        for (int i = 0; i < COUNT; i++) {
            BookRecord book = BookRecord.builder()
                    .author(
                            String.format(
                                    "%s, %s",
                                    StringUtils.capitalize(getRandomWordFromDict()),
                                    StringUtils.capitalize(getRandomWordFromDict())
                            )
                    )
                    .title(StringUtils.capitalize(getRandomWordFromDict()))
                    .build();
            repository.save(book);
        }
    }

    @Test
    public void deleteAllBookRecords() {
        repository.deleteAll();
    }

    private String getRandomWordFromDict() throws IOException {
        File wordsFile = ResourceUtils.getFile("classpath:words");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(wordsFile, "r")) {
            long rafLength = randomAccessFile.length();
            Random random = new Random();
            long pos = random.nextLong(rafLength);
            randomAccessFile.seek(pos);
            return randomAccessFile.readLine();
        }
    }
}
