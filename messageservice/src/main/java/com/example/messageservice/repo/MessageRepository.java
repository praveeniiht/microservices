package com.example.messageservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.messageservice.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

}
