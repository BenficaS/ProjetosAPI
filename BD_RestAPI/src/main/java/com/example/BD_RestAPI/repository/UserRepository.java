package com.example.BD_RestAPI.repository;

import com.example.BD_RestAPI.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findByNomeIgnoreCase(String nome);

    List<UserEntity> findByEmailIgnoreCase(String email);

    List<UserEntity> findByNomeAndEmailAllIgnoreCase(String email, String nome);

    List<UserEntity> findByNomeStartingWithIgnoreCase(String prefix);

    List<UserEntity> findByNomeContainingIgnoreCase(String sub);
}