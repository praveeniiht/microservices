package com.example.userservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.userservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
