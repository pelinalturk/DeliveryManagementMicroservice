package com.pelin.boxservice.repository;

import com.pelin.boxservice.model.Box;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface BoxRepository extends MongoRepository<Box, String> {
    List<Box> findAllById(String id);

    List<Box> findAllByRecipientId(String recipientId);

    Box findByRecipientId(String userId);
}
