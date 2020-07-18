package com.phos.springbootwebapplication.repositories;

import com.phos.springbootwebapplication.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
