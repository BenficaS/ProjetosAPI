package com.exemple.fipe.repository;
import com.exemple.fipe.model.EntityFipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
    @Repository
    public interface FipeRepository extends MongoRepository<EntityFipe, String> {
// Métodos de CRUD já estão disponíveis
//findAll, findById, save, deleteById
}
