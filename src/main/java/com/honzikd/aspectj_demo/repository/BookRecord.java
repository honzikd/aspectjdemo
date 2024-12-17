package com.honzikd.aspectj_demo.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRecord {

    @Id
    @UuidGenerator
    @Column(name = "id")
    String id;

    @Column
    String author;

    @Column
    String title;

    @Column
    String isbn;
}
