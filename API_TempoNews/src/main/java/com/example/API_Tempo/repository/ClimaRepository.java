package com.example.API_Tempo.repository;

import com.example.API_Tempo.model.ClimaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimaRepository extends MongoRepository<ClimaEntity, String> {
// Métodos de CRUD já estão disponíveis
//findAll, findById, save, deleteById
}