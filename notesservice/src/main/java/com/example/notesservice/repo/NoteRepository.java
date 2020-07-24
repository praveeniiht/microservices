package com.example.notesservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.notesservice.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note,Integer>{

}
