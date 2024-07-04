package com.example.API_Ibge.repository;

import com.example.API_Ibge.model.IbgeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IbgeRepository extends MongoRepository<IbgeEntity, String> {
// Métodos de CRUD já estão disponíveis
//findAll, findById, save, deleteById
}