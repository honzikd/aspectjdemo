package com.honzikd.aspectj_demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemoCrudRepository extends CrudRepository<BookRecord, UUID> { }
